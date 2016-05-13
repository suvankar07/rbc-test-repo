package com.rbc.test.app.bo;


/**
 * Item base class containing generic apis to be used by the underlying 
 * implementation classes
 * 
 * @author Suvankar Deb
 * 
 * */
public abstract class Item {
	
	/*
	 * Return the name of the item
	 */
	public String getName() {
		return getClass().getSimpleName();
	}
	
	/*
	 * Returns the type of the item
	 */
	public String getType() {
		return getClass().getSuperclass().getSimpleName();
	}
}
