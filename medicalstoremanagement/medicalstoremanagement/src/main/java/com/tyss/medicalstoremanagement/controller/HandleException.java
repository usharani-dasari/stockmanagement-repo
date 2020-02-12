package com.tyss.medicalstoremanagement.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tyss.medicalstoremanagement.dto.MedicalStoreResponse;

@RestControllerAdvice
public class HandleException {
	
	@ExceptionHandler(Exception.class)
	public MedicalStoreResponse getException() {
		MedicalStoreResponse response = new MedicalStoreResponse();
		response.setStatusCode(501);
		response.setMessage("Error in code");
		response.setDescription("Got an Exception");
		return response;
	}

}
