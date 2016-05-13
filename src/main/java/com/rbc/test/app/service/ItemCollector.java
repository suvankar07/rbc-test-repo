package com.rbc.test.app.service;

import com.rbc.test.app.bo.StoreTray;

/**
 * The interface provides api to collect item from the tray and put in shopping busket
 * @author Suvankar Deb
 *
 */
public interface ItemCollector<T> {
	/**
	 * The method collects the given number of items randomly from the store tray 
	 * and adds them to shopping basket 
	 * @param tray Tray of items
	 * @param numberOfItems number of items to be picked
	 * @return An instance of <code>ShoppingBasket</code> with the collected items
	 */
	public ShoppingBasket collectItems(StoreTray<T> tray, int numberOfItems);
	
	/**
	 * The method collects the items given by the item names from the store tray 
	 * and adds them in the shopping basket
	 * 
	 * @param tray Tray of items
	 * @param itemsToBePicked A list of item names to be picked
	 * @return An instance of <code>ShoppingBasket</code> with the collected items 
	 */
	public ShoppingBasket collectItems(StoreTray<T> tray, String[] itemsToBePicked);

}
