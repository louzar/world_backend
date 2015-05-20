package org.world.model;

import java.util.ArrayList;
import java.util.List;

import org.world.util.DateFormatter;


public class CountryDto {

	private String code;
	private long populationCount;
	private String capitalName;
    private String countryName;
    private String languageCode;
    private List<String> translations;
    private String creationDate;
    private String modificationDate;
    private String createdBy;
    private String modifiedBy;

    public CountryDto(){
    	
    }
	
	public CountryDto(Country country, List<CountryLn> countrylns) {
		code = country.getCode();
		populationCount = country.getPopulationCount();
		capitalName = country.getCapitalName();
		creationDate = DateFormatter.format(country.getCreationDate());
		modificationDate = DateFormatter.format(country.getModificationDate());
		createdBy = country.getCreatedBy().getUsername();
		modifiedBy = country.getModifiedBy().getUsername();
		translations = new ArrayList<String>();
		for(CountryLn cl: countrylns){
			translations.add(cl.getName());
		}
	}

	public Country buildCountry() {
		Country country = new Country(code, populationCount, capitalName);
		return country;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public long getPopulationCount() {
		return populationCount;
	}

	public void setPopulationCount(long populationCount) {
		this.populationCount = populationCount;
	}

	public String getCapitalName() {
		return capitalName;
	}

	public void setCapitalName(String capitalName) {
		this.capitalName = capitalName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}


	public CountryLn buildCountryLn() {
		CountryLn countryLn = new CountryLn(countryName);
		return countryLn;
	}

	@Override
	public String toString() {
		return "CountryDto [code=" + code + ", populationCount="
				+ populationCount + ", capitalName=" + capitalName
				+ ", countryName=" + countryName + ", languageCode="
				+ languageCode + translations + "]";
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public List<String> getTranslations() {
		return translations;
	}

	public void setTranslations(List<String> translations) {
		this.translations = translations;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public String getModificationDate() {
		return modificationDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}



}
