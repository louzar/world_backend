package org.world.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.world.dao.CountryDao;
import org.world.dao.CountryDaoImpl;
import org.world.model.CountryDto;
import org.world.model.CountryLn;
import org.world.model.Status;

// TODO: Auto-generated Javadoc
/**
 * The Class CountryRestController.
 */
@Controller
@RequestMapping("/countries")
public class CountryRestController {

	@Autowired
	CountryDao countryDao;

	/** The Constant logger. */
	static final Logger logger = Logger.getLogger(CountryRestController.class);

	/**
	 * Adds the countryDto.
	 *
	 * @param countryDto
	 *            the countryDto
	 * @return the status
	 */
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
