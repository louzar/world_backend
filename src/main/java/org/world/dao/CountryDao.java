package org.world.dao;

import org.world.model.CountryDto;
import org.world.model.CountryLn;

public interface CountryDao {

	public boolean addEntity(CountryDto countryDto) throws Exception ;

	public void addTranslation(CountryLn countryLn);

	public CountryDto getEntity(String code, boolean all);
	
}
