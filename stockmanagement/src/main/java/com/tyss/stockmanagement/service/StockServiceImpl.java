package com.tyss.stockmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.stockmanagement.dao.StockManagementDAO;
import com.tyss.stockmanagement.dto.Order_Info;
import com.tyss.stockmanagement.dto.Products_Info;

@Service
public class StockServiceImpl implements StockService {
	
	@Autowired
	private StockManagementDAO dao;

	@Override
	public Products_Info addProduct(Products_Info productInfo) {
		return dao.addProduct(productInfo);
	}

	@Override
	public boolean modifyProduct(Products_Info productInfo) {
		return dao.modifyProduct(productInfo);
	}

	@Override
	public List<Products_Info> getAllProducts(){
		return dao.getAllProducts();
	}

	@Override
	public Order_Info addProductToCart(Order_Info orderInfo) {
		return dao.addProductToCart(orderInfo);
	}

	@Override
	public List<Products_Info> search(String searchKey) {
		return dao.search(searchKey);
	}

}
