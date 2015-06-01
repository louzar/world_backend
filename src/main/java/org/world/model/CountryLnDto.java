package org.world.model;

public class CountryLnDto {
	private String countryName;
	private String capitalName;
	public CountryLnDto(String countryName, String capitalName) {
		super();
		this.countryName = countryName;
		this.capitalName = capitalName;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCapitalName() {
		return capitalName;
	}
	public void setCapitalName(String capitalName) {
		this.capitalName = capitalName;
	}

}
