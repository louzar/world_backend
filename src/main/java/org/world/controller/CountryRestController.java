package org.world.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.world.dao.CountryDao;
import org.world.model.CountryDto;
import org.world.model.CountryLn;
import org.world.model.Status;

// TODO: Auto-generated Javadoc
/**
 * The Class CountryRestController.
 */
@Controller
@RequestMapping("/api/rest/countries")
public class CountryRestController {

	@Autowired
	CountryDao countryDao;

	/** The Constant logger. */
	static final Logger logger = Logger.getLogger(CountryRestController.class);

	 
	@RequestMapping(value = "/get/{code}", method = RequestMethod.GET)
	public @ResponseBody CountryDto getCountries(@PathVariable String code, @RequestParam(value = "val", defaultValue = "", required = false) String val) {
		try {
			return countryDao.getEntity(code, val.equals("all"));
		} catch (Exception e) {			
			e.printStackTrace();
			return null;
		}
		

	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Status addCountry(@RequestBody CountryDto countryDto) {
		try {
			countryDao.addEntity(countryDto);
			return new Status(1, "Country added Successfully !");
		} catch (Exception e) {
			e.printStackTrace();
			return new Status(0, e.toString());
		}

	}
	
	@RequestMapping(value = "/add_translation", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Status addTranslation(@RequestBody CountryLn countryLn) {
		try {
			countryDao.addTranslation(countryLn);
			return new Status(1, "Translation added Successfully !");
		} catch (Exception e) {
			e.printStackTrace();
			return new Status(0, e.toString());
		}

	}
}
