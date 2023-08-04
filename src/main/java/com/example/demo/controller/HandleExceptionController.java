package com.example.demo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.AccountException;


@ControllerAdvice
public class HandleExceptionController {
	
	@ExceptionHandler(AccountException.class)
	public String handleUserException(AccountException ex) {
		return "Error: " + ex.getMessage();
	}
}
