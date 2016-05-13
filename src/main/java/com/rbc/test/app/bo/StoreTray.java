package com.rbc.test.app.bo;

import com.rbc.test.app.exception.ItemNotFoundException;

/**
 * This class defines a generic store tray
 * @author Suvankar Deb
 *
 * @param <T>
 */
public class StoreTray<T> {

	// Class variable
	Class clazz = null;

	// Constructor
	public StoreTray(Class clazz) {
		this.clazz = clazz;
	}

	// The api picks an item from the store tray
	public T pickItem(String itemClazz) throws ItemNotFoundException {
		try {
			
			return (T) Class.forName(itemClazz).newInstance();
			
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
			
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
			
		} catch (ClassNotFoundException e) {
			
			throw new ItemNotFoundException(e);
		}
	}
}
