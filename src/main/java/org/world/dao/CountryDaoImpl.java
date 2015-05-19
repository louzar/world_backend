package org.world.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.world.model.Country;
import org.world.model.CountryDto;
import org.world.model.CountryLn;
import org.world.model.Language;


public class CountryDaoImpl implements CountryDao{

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
		Query query = session.createQuery("from Language where code = :code ");
		System.out.println("countryDto.getLanguageName() " + countryDto.getLanguageName());
		query.setParameter("code", countryDto.getLanguageName());
		List<Language> list = query.list();
		Language language = null;
		if(list.size() > 0){
			 language = list.get(0);
		}	
		Country country = countryDto.getCountry();
		CountryLn countryLn = countryDto.getCountryLn();
		session.save(country);
		countryLn.setCountry(country);
		countryLn.setLanguage(language);
		session.save(countryLn);
		tx.commit();
		session.close();

		return false;
	}

	

}
