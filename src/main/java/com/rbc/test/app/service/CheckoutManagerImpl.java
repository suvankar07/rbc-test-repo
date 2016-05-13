package com.rbc.test.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rbc.test.app.bo.Item;

@Service
public class CheckoutManagerImpl implements CheckoutManager {

	// Class variables
	private List<Item> items;

	@Autowired
	private ItemRateChart itemRateChart;

	/*
	 * @see
	 * com.rbc.test.app.service.CheckoutManager#checkInItems(java.util.List)
	 */
	public boolean checkInItems(List<Item> items) {
		this.items = items;
		return true;
	}

	/*
	 * @see com.rbc.test.app.service.CheckoutManager#calculateTotalCost()
	 */
	public double calculateTotalCost() {
		double totalCost = 0.0;
		for (Item item : items) {
			totalCost = totalCost
					+ itemRateChart.getRateForItem(item.getName());
		}
		return totalCost;
	}

}
