package org.world.model;


public class CountryDto {

	private String code;
	private long populationCount;
	private String capitalName;
    private String countryName;
    private String languageName;
	

	
	public Country getCountry() {
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

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}



	public CountryLn getCountryLn() {
		CountryLn countryLn = new CountryLn(countryName);
		return countryLn;
	}

	@Override
	public String toString() {
		return "CountryDto [code=" + code + ", populationCount="
				+ populationCount + ", capitalName=" + capitalName
				+ ", countryName=" + countryName + ", languageName="
				+ languageName + "]";
	}



}
