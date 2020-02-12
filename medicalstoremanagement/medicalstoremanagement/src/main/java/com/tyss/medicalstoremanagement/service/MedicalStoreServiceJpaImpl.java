package com.tyss.medicalstoremanagement.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tyss.medicalstoremanagement.dto.OrderInfo;
import com.tyss.medicalstoremanagement.dto.ProductInfo;
import com.tyss.medicalstoremanagement.dto.UserInfo;
import com.tyss.medicalstoremanagement.repo.OrderInfoRepo;
import com.tyss.medicalstoremanagement.repo.ProductRepo;
import com.tyss.medicalstoremanagement.repo.UserRepo;

@Service
public class MedicalStoreServiceJpaImpl implements MedicalStoreService {
	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private OrderInfoRepo orderInfoRepo;

	@Override
	public boolean register(UserInfo userInfo) {
		userRepo.save(userInfo);
		return true;
	}

	@Override
	public UserInfo login(UserInfo userInfo) {
		UserInfo userInfo1 = userRepo.findByEmail(userInfo.getEmail());
		if(userInfo1!=null) {
			if(userInfo1.getPassword().equals(userInfo.getPassword())) {
				return userInfo1;
			}else {
				return null;
			}
		}
		return null;

	}

	@Override
	public boolean addProduct(ProductInfo productInfo) {
		productRepo.save(productInfo);
		return true;
	}

	@Override
	public List<ProductInfo> showProducts() {
		return productRepo.findAll();
	}

	@Override
	public OrderInfo placeOrder(OrderInfo orderInfo) {
		
		List<ProductInfo> products = orderInfo.getOrderedProducts();
		double totalPrice = 0.0;
		Iterator<ProductInfo> iterator = products.iterator();
		while(iterator.hasNext()) {
			ProductInfo product1 = iterator.next();
			ProductInfo product = productRepo.findById(product1.getPid()).get();
			totalPrice += product.getPrice();
			int quantity = product.getQuantity()-1;
			productRepo.updateQuantity(quantity, product.getPid());
		}
		orderInfo.setTotalPrice(totalPrice);
		orderInfoRepo.save(orderInfo);
		OrderInfo order = orderInfoRepo.findById(orderInfo.getOid()).get();
		return order;
		
	}

	@Override
	public List<ProductInfo> search(String searchKey) {
		List<ProductInfo> products = productRepo.search(searchKey);
		return products;
	}

	@Override
	public boolean editProduct(ProductInfo product) {
		productRepo.update(product.getpName(), product.getCompany(), product.getCategory(),
				product.getPtype(), product.getPrice(), product.getQuantity(), 
				product.getDescription(), product.getpImage(), product.getPid());
		return true;
	}

	@Override
	public boolean deleteProduct(ProductInfo product) {
		productRepo.deleteById(product.getPid());
		return true;
	}

	@Override
	public boolean deleteUser(UserInfo userInfo) {
		userRepo.deleteById(userInfo.getUid());
		return true;
	}
}
