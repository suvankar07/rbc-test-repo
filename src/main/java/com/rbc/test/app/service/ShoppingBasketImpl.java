package com.rbc.test.app.service;

import java.util.ArrayList;
import java.util.List;

import com.rbc.test.app.bo.Item;

/**
 * Implementation class of the interface <code>ShoppingBasket</code>
 * 
 * @author deep
 * 
 */
public class ShoppingBasketImpl implements ShoppingBasket {

	// Class Variable
	private List<Item> items = new ArrayList<Item>();

	/**
	 * @see ShoppingBusket#addItem(Item)
	 */
	public void addItem(Item item) {
		items.add(item);
	}

	public void removeItem(Item item) {
		items.remove(item);
	}

	/**
	 * @see ShoppingBusket#getAllItemFromBusket()
	 */
	public List<Item> getAllItemFromBusket() {
		return items;
	}

}
