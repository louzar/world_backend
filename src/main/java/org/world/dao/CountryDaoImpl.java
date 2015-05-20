package org.world.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.world.model.Country;
import org.world.model.CountryDto;
import org.world.model.CountryLn;
import org.world.model.Language;
import org.world.model.Users;

public class CountryDaoImpl implements CountryDao {

	/** The session factory. */
	@Autowired
	SessionFactory sessionFactory;

	/** The session. */
	Session session = null;

	/** The tx. */
	Transaction tx = null;

	
	public boolean addEntity(CountryDto countryDto) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();	
        Users user = getCurrentUser();
		Query query = session.createQuery("from Language where code = :code ");
		query.setParameter("code", countryDto.getLanguageCode());
		List<Language> list = query.list();
		Language language = null;
		if (list.size() > 0) {
			language = list.get(0);
		}
		Country country = countryDto.buildCountry();
		Date date = new Date();
		country.setCreationDate(date);
		country.setModificationDate(date);
		country.setCreatedBy(user);
		country.setModifiedBy(user);
		CountryLn countryLn = countryDto.buildCountryLn();
		session.save(country);
		countryLn.setCountry(country);
		countryLn.setLanguage(language);
		session.save(countryLn);
		tx.commit();
		session.close();

		return true;
	}

	@Override
	public void addTranslation(CountryLn countryLn) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		Users user = getCurrentUser();
		Country country = (Country) session.get(Country.class, countryLn.getCountry().getId());
		country.setModificationDate(new Date());
		country.setModifiedBy(user);
		session.update(country);
		session.save(countryLn);
		tx.commit();
		session.close();

	}

	@Override
	public CountryDto getEntity(CountryDto countryDto) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		Users user = getCurrentUser();
		Query countryquery = session.createQuery("from Country where code = :code ");
		countryquery.setParameter("code", countryDto.getCode());
		Country country = (Country) countryquery.list().get(0);
		List<CountryLn> countrylns;
		if (countryDto.getLanguageCode() != null && countryDto.getLanguageCode().equals("all")) {
			Query translationQuery = session.createQuery("from CountryLn where country = :country");
			translationQuery.setParameter("country", country);
			countrylns = translationQuery.list();
		} else {

			Query translationQuery = session.createQuery("from CountryLn where language = :language And country = :country");
			translationQuery.setParameter("language", user.getLanguage());
			translationQuery.setParameter("country", country);
			countrylns = translationQuery.list();

		}
		countryDto = new CountryDto(country, countrylns );
		tx.commit();
		session.close();
		return countryDto;

	}
	private Users getCurrentUser(){
		User loggedUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Query userquery = session.createQuery("from Users where username = :username ");
		userquery.setParameter("username",loggedUser.getUsername());
		return(Users) userquery.list().get(0);
	}

}
