package com.jsp.userm7.exception;

import lombok.Getter;

@Getter
public class UserIdNotFoundException extends RuntimeException {

	private String message;

	public UserIdNotFoundException(String message) {
		super();
		this.message = message;
	}
	
}
