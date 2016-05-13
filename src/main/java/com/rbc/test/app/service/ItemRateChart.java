package com.rbc.test.app.service;

/**
 * The interface contains api to access the rate, i.e price per unit 
 * of any item. 
 * @author Suvankar Deb
 *
 */
public interface ItemRateChart {
	/**
	 * Returns the rate associated with an item
	 * @param itemName name of an item
	 * @return
	 */
	public double getRateForItem(String itemName);
	
	/**
	 * Returns the item name on that given index in the item/rate list
	 * @param index item index
	 * @return name of item
	 */
	public String getName(int index);
	
}
