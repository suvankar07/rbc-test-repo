package com.rbc.test.app.constants;

/**
 * The enum class defines all the available fruits and their rates
 * in terms of price per unit in GBP
 * @author Suvankar Deb
 *
 */
public enum Fruits {
	//Collection of declared fruits and their rates
	Banana(0.50), Orange(0.75), Apple(1.25), Peach(0.60), Lemon(0.40);
	
	//Attribute
	private double pricePerUnit;
	
	//Enum constructor
	private Fruits(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	
	//Public api for accessing enum values
	public double getPrice(){
		return this.pricePerUnit;
	}
	
}
