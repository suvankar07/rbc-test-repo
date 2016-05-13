package com.rbc.test.app.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

/**
 * The class provides api, which loads the rates from file system. The file
 * contains rates in the form of, "Orange, 1.20", meaning cost of orange per
 * unit is £1.20
 * 
 * @author Suvankar Deb
 * 
 */

@Repository
public class FileRateSource implements RateSource {
	// Class logger
	private static final Logger logger = Logger.getLogger(FileRateSource.class
			.getName());

	// Class variables
	@Value("${item.rate.file}")
	private String rateFile;

	/*
	 * @see com.rbc.test.app.dao.RateSource#load()
	 */
	public Map<String, Double> load() {

		Map<String, Double> rates = new HashMap<String, Double>();
		
		logger.info("Loading rates from -> " + rateFile);

		Resource resource = new ClassPathResource(rateFile);
		
		try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {
			String line;

			while ((line = br.readLine()) != null) {

				String[] values = line.split(",");
				System.out.println("FileRateSource->" + values[0] + ":" + values[1]);
				rates.put(values[0], Double.valueOf(values[1]));
			}

		} catch (IOException e) {
			throw new IllegalAccessError(e.getMessage());
		}
		System.out.println("Size->" + rates.size());
		return rates;
	}

}
