package com.tyss.stockmanagement.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.tyss.stockmanagement.dto.StockResponse;

@RestControllerAdvice
public class HandleException {

	@ExceptionHandler(Exception.class)
	public  StockResponse getException() {
		StockResponse response = new StockResponse();
		response.setStatusCode(501);
		response.setMessage("Error in code");
		response.setDescription("Got an Exception");
		return response;
	}
}
