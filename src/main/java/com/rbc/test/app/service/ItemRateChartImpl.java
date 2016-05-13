package com.rbc.test.app.service;

import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rbc.test.app.dao.RateSource;

/**
 * The class on start initialises the rates associated with the items from a
 * standard csv file source. It provide api to access the rate associated with
 * an item.
 * 
 * @author Suvankar Deb
 * 
 */
@Service
public class ItemRateChartImpl implements ItemRateChart, InitializingBean {

	// Class variable
	private Map<String, Double> itemRates;

	private String[] itemNames;

	@Autowired
	private RateSource rateSource;

	/*
	 * @see
	 * com.rbc.test.app.service.ItemRateChart#getRateForItem(java.lang.String)
	 */
	public double getRateForItem(String itemName) {

		return itemRates.get(itemName);
	}

	/*
	 * @see com.rbc.test.app.service.ItemRateChart#getName(int)
	 */
	public String getName(int index) {
		if (itemNames != null & index <= itemNames.length - 1)
			return itemNames[index];
		else
			throw new IllegalArgumentException(
					"No item exist for the given index or incorrect index given ->"
							+ index);
	}

	/**
	 * Callback method. Loads the rates
	 */
	public void afterPropertiesSet() throws Exception {
		// Loading the item and the corresponding rates
		itemRates = rateSource.load();
		
		// Assigning names of all listed items in an array
		itemNames = itemRates.keySet().toArray(new String[itemRates.size()]);

	}
		
}


