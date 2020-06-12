package com.front.exceptions;
public class InvalidJsonException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public InvalidJsonException(String message) {
		 super(message);
	}
	
	public InvalidJsonException() {
		 super();
	}

}
