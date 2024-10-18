package com.tnsif.exceptions;



/**
 * Custom exception class for handling entity not found exceptions.
 */
public class EntityNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(String message) {
        super(message);
       
    }
	
}
