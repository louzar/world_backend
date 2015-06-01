package org.world.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.transaction.annotation.Transactional;
import org.world.model.Country;
import org.world.model.CountryDto;
import org.world.model.CountryLn;
import org.world.model.Language;
import org.world.model.Users;

@Transactional
public class CountryDaoImpl implements CountryDao {

	@PersistenceContext
	EntityManager entityManager;

	
	public boolean addEntity(CountryDto countryDto) throws Exception {

	
        Users user = getCurrentUser();
        
		Query query = entityManager.createQuery("from Language where code = :code ");
		query.setParameter("code", countryDto.getLanguageCode());
		List<Language> list = query.getResultList();
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
		entityManager.persist(country);
		countryLn.setCountry(country);
		countryLn.setLanguage(language);
		entityManager.persist(countryLn);


		return true;
	}

	@Override
	public void addTranslation(CountryLn countryLn) {

		Users user = getCurrentUser();
		Country country = (Country) entityManager.find(Country.class, countryLn.getCountry().getId());
		Language language = (Language) entityManager.find(Language.class, countryLn.getLanguage().getId());
		country.setModificationDate(new Date());
		country.setModifiedBy(user);
		entityManager.merge(country);
		countryLn.setCountry(country);
		countryLn.setLanguage(language);
		entityManager.persist(countryLn);


	}

	@Override
	public CountryDto getEntity(String code, boolean all) {

		Users user = getCurrentUser();
		Query countryquery = entityManager.createQuery("from Country where code = :code ");
		countryquery.setParameter("code", code);
		Country country = (Country) countryquery.getResultList().get(0);
		List<CountryLn> countrylns;
		CountryDto countryDto =  new CountryDto();
		if (all) {
			Query translationQuery = entityManager.createQuery("from CountryLn where country = :country");
			translationQuery.setParameter("country", country);
			countrylns = translationQuery.getResultList();
		} else {

			Query translationQuery = entityManager.createQuery("from CountryLn where language = :language And country = :country");
			translationQuery.setParameter("language", user.getLanguage());
			translationQuery.setParameter("country", country);
			countrylns = translationQuery.getResultList();

		}

		 
		return new CountryDto(country,countrylns) ;

	}
	private Users getCurrentUser(){
		User loggedUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Query userquery = entityManager.createQuery("from Users where username = :username ");
		userquery.setParameter("username",loggedUser.getUsername());
		return(Users) userquery.getResultList().get(0);
	}

}
