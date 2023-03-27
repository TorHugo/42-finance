package com.br.finance.exception.impl;

public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
