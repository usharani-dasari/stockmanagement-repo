package com.tyss.medicalstoremanagement.dto;

import java.util.List;

public class MedicalStoreResponse {
	private int statusCode;
	private String description;
	private String message;
	private UserInfo userInfo;
	private List<ProductInfo> products;
	private OrderInfo order;
	
	public OrderInfo getOrder() {
		return order;
	}
	public void setOrder(OrderInfo order) {
		this.order = order;
	}
	public List<ProductInfo> getProducts() {
		return products;
	}
	public void setProducts(List<ProductInfo> products) {
		this.products = products;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
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
