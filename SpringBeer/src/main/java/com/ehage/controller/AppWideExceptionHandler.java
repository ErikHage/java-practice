package com.ehage.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ehage.exception.BeerNotFoundException;

//@ControllerAdvice
public class AppWideExceptionHandler {

//	@ExceptionHandler(BeerNotFoundException.class)
//	@ResponseStatus(HttpStatus.NOT_FOUND)
//	public @ResponseBody BeerNotFoundException handleBeerNotFound(BeerNotFoundException e) {
//		return e;
//	}
	
}
