package com.example.InsuranceManagementPlatForm.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<GlobalErrorResponse> handleException(GlobalNotFoundException exc){
	 //creating ClientErrorResponse
	GlobalErrorResponse error = new GlobalErrorResponse();
	         error.setStatus(HttpStatus.NOT_FOUND.value());
	         error.setMessage(exc.getMessage());
	         error.setTimeStamp(System.currentTimeMillis());
	
	         return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	//Generic ExceptionHandling
	@ExceptionHandler
	public ResponseEntity<GlobalErrorResponse> handleException(Exception exc){
		 //create ClientErrorResponse
		GlobalErrorResponse error = new GlobalErrorResponse();
		         error.setStatus(HttpStatus.BAD_REQUEST.value());
		         error.setMessage(exc.getMessage());
		         error.setTimeStamp(System.currentTimeMillis());
		
		         return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		}
}
