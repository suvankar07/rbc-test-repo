package com.rbc.test.app.exception;

public class ItemNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Constructor
	public ItemNotFoundException(Throwable t){
		super(t);
	}

}
