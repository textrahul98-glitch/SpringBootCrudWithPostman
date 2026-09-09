package com.example.demo.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.management.InvalidApplicationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	/*
	 * @ExceptionHandler(EmployeeNotFoundException.class) public
	 * ResponseEntity<String>
	 * handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
	 * 
	 * return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND); }
	 */

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorResponce> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {

		ErrorResponce error = new ErrorResponce(
				404, 
				ex.getMessage(), 
				LocalDateTime.now().toString(),
				null);

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponce> handleEmployeeNotFoundException(Exception ex) {

		ErrorResponce error = new ErrorResponce(
				404, 
				"Internal Server Error", 
				LocalDateTime.now().toString(),
				null);

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponce> handleValidationException(MethodArgumentNotValidException ex) {

		Map<String ,String> errors= new HashMap();
		ex.getBindingResult().getAllErrors().forEach(error->{
			errors.put(error.getObjectName(), error.getDefaultMessage());
		
		});
		
		ErrorResponce error = new ErrorResponce(
				400, 
				"Validation Failed", 
				LocalDateTime.now().toString(),
				errors);
				

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
