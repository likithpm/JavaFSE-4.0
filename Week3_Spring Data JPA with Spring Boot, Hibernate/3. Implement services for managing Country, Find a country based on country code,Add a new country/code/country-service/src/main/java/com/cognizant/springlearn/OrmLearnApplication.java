package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);

        getCountryByCodeTest();
        testAddCountry();
    }

    private static void getCountryByCodeTest() {
        LOGGER.info("Start");

        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Country: {}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Exception: {}", e.getMessage());
        }

        LOGGER.info("End");
    }

    private static void testAddCountry() {
        LOGGER.info("Start");

        Country newCountry = new Country();
        newCountry.setCode("ZZ");
        newCountry.setName("Zootopia");

        countryService.addCountry(newCountry);

        try {
            Country addedCountry = countryService.findCountryByCode("ZZ");
            LOGGER.debug("Added Country: {}", addedCountry);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country not found after adding: {}", e.getMessage());
        }

        LOGGER.info("End");
    }
}
