package com.rbc.test.app.service;

import java.util.List;

import com.rbc.test.app.bo.Item;

/**
 * This is a shopping busket interface containing apis to access and manage the
 * shopping basket
 * 
 * @author Suvankar Deb
 * 
 */
public interface ShoppingBasket {
	/**
	 * Adds an item to the shopping busket
	 * 
	 * @param item
	 *            An instance of <code>Item</code>
	 */
	public void addItem(Item item);

	/**
	 * Removes an item from the shopping busket
	 * 
	 * @param item
	 *            An instance of <code>Item</code>
	 */
	public void removeItem(Item item);

	/**
	 * Returns all the items, which are added to the busket
	 * 
	 * @return A collection of instances of <code>Item</code>
	 */
	public List<Item> getAllItemFromBusket();
}
