package com.rest.exception;

public class PostNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -5849577239481604217L;

	public PostNotFoundException(String msg) {
		super(msg);
	}

}
