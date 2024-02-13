package com.Employee.Exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {
	
	@ExceptionHandler(value= EmployeeException.class)
	public ResponseEntity<Object> listExceptionHandling(EmployeeException ee) {
		return new ResponseEntity<> (ee.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = NoSuchElementException.class)
	public ResponseEntity<Object> noSuch(NoSuchElementException nse) {
		return new ResponseEntity<> (nse.getMessage(), HttpStatus.NOT_FOUND);
	}

}
