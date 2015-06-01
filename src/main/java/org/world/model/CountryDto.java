package org.world.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.world.util.CustomDateSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class CountryDto {

	private String code;
	private long populationCount;
	private String capitalName;
    private String countryName;
    private String languageCode;
    private List<CountryLnDto> translations;
    private Date creationDate;
    private Date modificationDate;
    private String createdBy;
    private String modifiedBy;

    public CountryDto(){
    	
    }
	
	public CountryDto(Country country, List<CountryLn> countrylns) {
		code = country.getCode();
		populationCount = country.getPopulationCount();
		creationDate = country.getCreationDate();
		modificationDate = country.getModificationDate();
		createdBy = country.getCreatedBy().getUsername();
		modifiedBy = country.getModifiedBy().getUsername();
		translations =  new  ArrayList<CountryLnDto>();
		for(CountryLn cln : countrylns){
			translations.add(new CountryLnDto(cln.getName(), cln.getCapitalName()));
		}
		

	}

	public Country buildCountry() {
		Country country = new Country(code, populationCount);
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


	public void setCapitalName(String capitalName) {
		this.capitalName = capitalName;
	}


	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}


	public CountryLn buildCountryLn() {
		CountryLn countryLn = new CountryLn(countryName, capitalName);
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

	public List<CountryLnDto> getTranslations() {
		return translations;
	}

	public void setTranslations(List<CountryLnDto> countrylns) {
		this.translations = countrylns;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getCreationDate() {
		return creationDate;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getModificationDate() {
		return modificationDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}



}
