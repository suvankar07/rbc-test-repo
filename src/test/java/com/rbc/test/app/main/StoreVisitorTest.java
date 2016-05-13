package com.rbc.test.app.main;

import static org.easymock.EasyMock.*;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.rbc.test.app.bo.Apple;
import com.rbc.test.app.bo.Banana;
import com.rbc.test.app.bo.Fruit;
import com.rbc.test.app.bo.Orange;
import com.rbc.test.app.bo.StoreTray;
import com.rbc.test.app.service.CheckoutManager;
import com.rbc.test.app.service.ItemCollector;
import com.rbc.test.app.service.ShoppingBasket;
import com.rbc.test.app.service.ShoppingBasketImpl;

/**
 * Test class for the StoreVisitor implementation
 * 
 * @author Suvankar Deb
 * 
 */
@RunWith(EasyMockRunner.class)
public class StoreVisitorTest {

	@Mock
	private ItemCollector<Fruit> itemCollector;

	@Mock
	private CheckoutManager checkoutManager;

	@TestSubject
	private StoreVisitor storeVisitor = new StoreVisitor();

	// Data Structure
	private ShoppingBasket basket;

	private StoreTray<Fruit> tray;

	private String[] fruitList;

	/**
	 * 
	 */
	@Test
	public void whenAValidListOfFruitIsPassed() {
		// Data
		fruitList = new String[] { "Apple", "Banana", "Orange" };
		tray = new StoreTray<>(Fruit.class);
		basket = new ShoppingBasketImpl();
		basket.addItem(new Apple());
		basket.addItem(new Orange());
		basket.addItem(new Banana());

		expect(
				itemCollector.collectItems(isA(StoreTray.class),
						isA(String[].class))).andReturn(basket);

		replay(itemCollector);

		expect(checkoutManager.calculateTotalCost()).andReturn(2.75);
		expect(checkoutManager.checkInItems(basket.getAllItemFromBusket()))
				.andReturn(true);
		replay(checkoutManager);

		double cost = storeVisitor.beginShopping(fruitList);
		Assert.assertEquals(2.75, cost, 0);
		verify(itemCollector);

		verify(checkoutManager);

	}

	@Test
	public void whenAnEmptyFruitListIsPassed() {
		// Data
		fruitList = new String[] {};
		tray = new StoreTray<>(Fruit.class);
		basket = new ShoppingBasketImpl();
	

		expect(
				itemCollector.collectItems(isA(StoreTray.class),
						isA(String[].class))).andReturn(basket);

		replay(itemCollector);

		expect(checkoutManager.calculateTotalCost()).andReturn(0.0);
		expect(checkoutManager.checkInItems(basket.getAllItemFromBusket()))
				.andReturn(true);
		replay(checkoutManager);

		double cost = storeVisitor.beginShopping(fruitList);
		Assert.assertEquals(0.0, cost, 0);
		
		verify(itemCollector);
		verify(checkoutManager);
	}
	
	@Test
	public void whenAFruitListWithUnknownFruitIsPassed() {
		// Data
		fruitList = new String[] {};
		tray = new StoreTray<>(Fruit.class);
		basket = new ShoppingBasketImpl();
	

		expect(
				itemCollector.collectItems(isA(StoreTray.class),
						isA(String[].class))).andReturn(basket);

		replay(itemCollector);

		expect(checkoutManager.calculateTotalCost()).andReturn(0.0);
		expect(checkoutManager.checkInItems(basket.getAllItemFromBusket()))
				.andReturn(true);
		replay(checkoutManager);

		double cost = storeVisitor.beginShopping(fruitList);
		Assert.assertEquals(0.0, cost, 0);
		
		verify(itemCollector);
		verify(checkoutManager);
	}

	@Test
	public void whenAFruitListWithUnknownAndKnownFruitIsPassed() {
		// Data
		fruitList = new String[] {"Apple", "Banana", "Mango" };
		tray = new StoreTray<>(Fruit.class);
		basket = new ShoppingBasketImpl();
		basket.addItem(new Apple());
		basket.addItem(new Banana());

		expect(
				itemCollector.collectItems(isA(StoreTray.class),
						isA(String[].class))).andReturn(basket);

		replay(itemCollector);

		expect(checkoutManager.calculateTotalCost()).andReturn(1.25);
		expect(checkoutManager.checkInItems(basket.getAllItemFromBusket()))
				.andReturn(true);
		replay(checkoutManager);

		double cost = storeVisitor.beginShopping(fruitList);
		Assert.assertEquals(1.25, cost, 0);
		
		verify(itemCollector);
		verify(checkoutManager);
	}
}
