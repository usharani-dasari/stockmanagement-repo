package com.tyss.stockmanagement.dao;

import java.util.List;

import com.tyss.stockmanagement.dto.Order_Info;
import com.tyss.stockmanagement.dto.Products_Info;

public interface StockManagementDAO {
	public Products_Info addProduct(Products_Info productInfo);
	public boolean modifyProduct(Products_Info productInfo);
	public List<Products_Info> getAllProducts();
	public List<Products_Info> search(String searchKey);
	public Order_Info addProductToCart(Order_Info orderInfo);

}
