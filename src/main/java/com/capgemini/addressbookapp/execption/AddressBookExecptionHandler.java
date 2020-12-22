package com.capgemini.addressbookapp.execption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class AddressBookExecptionHandler {
	@ExceptionHandler(AddressBookException.class)
	public ResponseEntity<String> handleEmployeeException(AddressBookException addressException){
		return new ResponseEntity<>(addressException.getMessage(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleEmployeeException(Exception empException){
		return new ResponseEntity<>(empException.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
