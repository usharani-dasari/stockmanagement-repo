package com.tyss.medicalstoremanagement.service;

import java.util.List;


import com.tyss.medicalstoremanagement.dto.OrderInfo;
import com.tyss.medicalstoremanagement.dto.ProductInfo;
import com.tyss.medicalstoremanagement.dto.UserInfo;



public interface MedicalStoreService {
	public boolean register(UserInfo userInfo);
	public UserInfo login(UserInfo userInfo);
	public boolean addProduct(ProductInfo productInfo);
	public List<ProductInfo> showProducts();
	public OrderInfo placeOrder(OrderInfo orderInfo);
	public List<ProductInfo> search(String searchKey);
	public boolean editProduct(ProductInfo product);
	public boolean deleteProduct(ProductInfo product);
	public boolean deleteUser(UserInfo userInfo);
}
