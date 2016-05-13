package com.rbc.test.app.service;

import java.util.Random;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import com.rbc.test.app.bo.Item;
import com.rbc.test.app.bo.StoreTray;
import com.rbc.test.app.constants.Constants;
import com.rbc.test.app.exception.ItemNotFoundException;

/**
 * Abstract item collector class providing definition of item collection apis
 * 
 * @author Suvankar Deb
 * 
 * 
 */

public abstract class AbstractItemCollector<T extends Item> implements
		ItemCollector<T> {
	// Class logger
	protected static Logger logger = Logger.getLogger("ItemCollector");

	// Collaborator
	@Autowired
	private ItemRateChart itemRateChart;

	/*
	 * 
	 * @see
	 * com.rbc.test.app.service.ItemCollector#collectItems(com.rbc.test.app.
	 * bo.StoreTray, int)
	 */
	public ShoppingBasket collectItems(StoreTray<T> tray, int numberOfItems) {

		// Creating an instance of shopping basket
		ShoppingBasket basket = new ShoppingBasketImpl();

		/*
		 * A random number generator which will give a number between 0-4 to
		 * pick an item randomly
		 */
		Random uniqueNumberGenerator = new Random();
		int uniqueNumber;

		for (int i = 0; i < numberOfItems; i++) {
			uniqueNumber = uniqueNumberGenerator.nextInt(5);
			// Randomly picking fruit item
			String itemName = itemRateChart.getName(uniqueNumber);

			T item;
			try {
				item = tray.pickItem(Constants.ItemPackage.concat(itemName));
				
				// Adding items to the shopping basket
				basket.addItem(item);
				
			} catch (ItemNotFoundException e) {
				logger.warning("Item ".concat(itemName).concat(" not found"));
			}
			
		}

		return basket;
	}

	/*
	 * 
	 * @see
	 * com.rbc.test.app.service.ItemCollector#collectItems(com.rbc.test.app.
	 * bo.StoreTray, java.lang.String[])
	 */
	public ShoppingBasket collectItems(StoreTray<T> tray,
			String[] itemsToBePicked) {

		// Creating an instance of shopping basket
		ShoppingBasket basket = new ShoppingBasketImpl();

		/*
		 * Looping through the item list to pick them from tray and add them to
		 * the basket
		 */
		for (String itemName : itemsToBePicked) {
			T item;
			try {
				item = tray.pickItem(Constants.ItemPackage.concat(itemName));

				// Adding items to the shopping basket
				basket.addItem(item);

			} catch (ItemNotFoundException e) {
				logger.warning("Item ".concat(itemName).concat(" not found"));
			}

		}

		return basket;
	}
}
