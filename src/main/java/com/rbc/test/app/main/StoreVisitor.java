package com.rbc.test.app.main;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.rbc.test.app.bo.Fruit;
import com.rbc.test.app.bo.StoreTray;
import com.rbc.test.app.service.CheckoutManager;
import com.rbc.test.app.service.ItemCollector;
import com.rbc.test.app.service.ShoppingBasket;

/**
 * An actor class representing store visitor, who will collect fruits and
 * finally checkout and pay for the items based on total cost.
 * 
 * @author Suvankar Deb
 * 
 */

@Component
@Scope("prototype")
public class StoreVisitor {

	// Class Logger
	private static final Logger logger = Logger.getLogger(StoreVisitor.class
			.getName());
	// Constants
	private static int Max = 50;
	private static int Min = 20;

	// Class variable
	private double totalCost = 0.0;
	private boolean shoppingCommenced = false;
	private StoreTray<Fruit> tray;

	// Collaborators
	@Autowired
	@Qualifier("fruitCollector")
	private ItemCollector<Fruit> itemCollector;

	@Autowired
	private CheckoutManager checkoutManager;

	/**
	 * The method when invoked collects a random number of items (fruits) and
	 * calculates the total price
	 * @return Returns the total amount
	 */
	public double beginShopping() {

		// Setting the shopping commence flag
		shoppingCommenced = true;

		/*
		 * Initialising fruit tray in the store which will different types of
		 * fruits to be picked up for purchase
		 */
		tray = new StoreTray<Fruit>(Fruit.class);

		/*
		 * Random number generator will be used to pick up a random number which
		 * will denote the number of items that will be picked. The range is 20
		 * .. 50 , the number of fruits can be one of the number from this range
		 */
		Random numberGenerator = new Random();
		int numberOfItems = numberGenerator.nextInt(Max - Min + 1) + Min;

		// Items will be collected now and placed in the shopping basket
		logger.info("No of items collecting into basket -> " + numberOfItems);
		ShoppingBasket basket = itemCollector
				.collectItems(tray, numberOfItems);

		/*
		 * Checkout manager will checkin the items from shopping basket and
		 * calculates total cost
		 */

		// Checking in items
		checkoutManager.checkInItems(basket.getAllItemFromBusket());

		// Calculating cost
		totalCost = checkoutManager.calculateTotalCost();
		logger.info("Calculated total cost of shopping -> £" + totalCost);
		
		return totalCost;

	}

	/**
	 * The method takes in a list of items that needs to be picked up and
	 * finally calculates the total price associated with the items
	 * 
	 * @param items
	 *            An array of items
	 * @return total cost to pay
	 */
	public double beginShopping(String[] items) {
		// Setting the shopping commence flag
		shoppingCommenced = true;

		/*
		 * Initialising fruit tray in the store which will different types of
		 * fruits to be picked up for purchase
		 */
		tray = new StoreTray<Fruit>(Fruit.class);

		// Items will be collected now and placed in the shopping basket
		ShoppingBasket basket = itemCollector
				.collectItems(tray, items);
		
		/*
		 * Checkout manager will checkin the items from shopping basket and
		 * calculates total cost
		 */

		// Checking in items
		checkoutManager.checkInItems(basket.getAllItemFromBusket());

		// Calculating cost
		totalCost = checkoutManager.calculateTotalCost();
		logger.info("Calculated total cost of shopping -> £" + totalCost);
		
		return totalCost;
	}

	/**
	 * The method takes in a collection of items that needs to be picked up and
	 * finally calculates the total price associated with the items
	 * 
	 * @param items
	 *            A collection of items
	 */
	public double beginShopping(List<String> items) {
		return beginShopping((String[]) items.toArray());
	}

	/**
	 * Returns the total cost of all the items
	 */
	public double totalAmountToPay() {
		return this.shoppingCommenced ? this.totalCost : 0.0;
	}

}
