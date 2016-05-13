package com.rbc.test.app.dao;

import java.util.Map;

/**
 * Provides api to load rates from underlying data source
 * @author deep
 *
 */
public interface RateSource {
	
	/*
	 * Loads the rates from underlying data source
	 */
	public Map<String, Double> load();
}
