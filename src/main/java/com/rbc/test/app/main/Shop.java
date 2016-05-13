package com.rbc.test.app.main;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * The main class which provides a store visitor opportunity to buy items from
 * the shop
 * 
 * @author Suvankar Deb
 * 
 */
@SpringBootApplication
public class Shop {
	// Class Logger
	private static final Logger logger = Logger.getLogger(Shop.class.getName());

	// Main class
	public static void main(String[] args) {
		
		//Initialising Spring context
//		ApplicationContext context = new ClassPathXmlApplicationContext(
//				new String[] { "rbc-application-context.xml" });
		ApplicationContext context = SpringApplication.run(Shop.class, args);
		
		StoreVisitor newVisitor = (StoreVisitor) context.getBean("storeVisitor");
		
		// The visitor begins shopping
		logger.info("Beginning Shopping");
		newVisitor.beginShopping();
		
		
		// Total amount to pay
		logger.info("Calculating total amount to pay");
		double totalCost = newVisitor.totalAmountToPay();
		
		// Capturing the total cost
		logger.info("Total Cost -> £" + totalCost);
	}
	
}
