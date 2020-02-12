package com.tyss.stockmanagement.dto;

import java.util.List;

public class StockResponse {
	private int statusCode;
	private String description;
	private String message;
	private List<Products_Info> products;
	private Order_Info orderInfo;
	private Products_Info productInfo;
	
	public Products_Info getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(Products_Info productInfo) {
		this.productInfo = productInfo;
	}
	public Order_Info getOrderInfo() {
		return orderInfo;
	}
	public void setOrderInfo(Order_Info orderInfo) {
		this.orderInfo = orderInfo;
	}
	public List<Products_Info> getProducts() {
		return products;
	}
	public void setProducts(List<Products_Info> products) {
		this.products = products;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
