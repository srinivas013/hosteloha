package com.RestAPI.hosteloha.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler  {

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UsernameNotFoundException ex, WebRequest request) throws Exception {
		ExceptionResponse response= new ExceptionResponse(ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
		
	}
}
