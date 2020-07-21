package com.RestAPI.hosteloha.exception;

import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler  {

	@ExceptionHandler(EntityNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(EntityNotFoundException ex, WebRequest request) throws Exception {
		ExceptionResponse response= new ExceptionResponse(ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public final ResponseEntity<Object> handleNosuchElementException(NoSuchElementException ex,WebRequest request) {
		ExceptionResponse response= new ExceptionResponse(ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
	}
}
