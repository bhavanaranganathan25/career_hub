package com.exception;

public class InvalidEmailFormatting extends Exception{
	public String getMessage() {
		return message;
	}
	public InvalidEmailFormatting(String message) {
		super();
		this.message = message;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
}
