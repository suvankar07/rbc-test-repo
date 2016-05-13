package com.rbc.test.app.service;

import java.util.List;

import com.rbc.test.app.bo.Item;

/**
 * The checkout manager is responsible for collecting the items and calculating 
 * the total cost to pay.
 * @author Suvankar Deb
 *
 */
public interface CheckoutManager {
	/**
	 * The method takes in the items from basket.
	 * @param items
	 */
	public boolean checkInItems(List<Item> items);
	
	/**
	 * Calculates total cost of all the items checked in.
	 * @return
	 */
	public double calculateTotalCost();
}
