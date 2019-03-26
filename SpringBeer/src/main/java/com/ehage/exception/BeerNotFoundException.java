package com.ehage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Beer Not Found")
public class BeerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 5597652820239361051L;
	
	private long id;
	private String message;
	
	public BeerNotFoundException(long id, String message) {
		this.id = id;
		this.message = message;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
