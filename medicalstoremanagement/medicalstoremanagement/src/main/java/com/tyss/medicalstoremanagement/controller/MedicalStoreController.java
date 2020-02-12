package com.tyss.medicalstoremanagement.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.tyss.medicalstoremanagement.dto.MedicalStoreResponse;
import com.tyss.medicalstoremanagement.dto.OrderInfo;
import com.tyss.medicalstoremanagement.dto.ProductInfo;
import com.tyss.medicalstoremanagement.dto.UserInfo;
import com.tyss.medicalstoremanagement.service.MedicalStoreService;

@RestController
public class MedicalStoreController {
	
	@Autowired
	private MedicalStoreService service;
	
	@PostMapping(path = "/register",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public MedicalStoreResponse register(@RequestBody UserInfo userInfo) {
		MedicalStoreResponse response = new MedicalStoreResponse();
		if(service.register(userInfo)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Data Added to the DB");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Data Not Added To The DB");
		}
		return response;
	}
	

	@PostMapping(path = "/login",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public MedicalStoreResponse login(@RequestBody UserInfo userInfo) {
		MedicalStoreResponse response = new MedicalStoreResponse();
		UserInfo userInfo1 = service.login(userInfo);
		if(userInfo1!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Data found in DB");
			response.setUserInfo(userInfo1);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Data Not found in DB");
		}
		return response;
	}
	
	@PostMapping(path = "/addproduct",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public MedicalStoreResponse addProduct(@RequestBody ProductInfo productInfo) {
		MedicalStoreResponse response = new MedicalStoreResponse();
		if(service.addProduct(productInfo)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Product Added to the DB");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Product Not Added To The DB");
		}
		return response;
	}
	@GetMapping(path = "/showproducts",
			produces =  MediaType.APPLICATION_JSON_VALUE)
	public MedicalStoreResponse showProducts() {
		MedicalStoreResponse response = new MedicalStoreResponse();
		List<ProductInfo> products = service.showProducts();
		if(products!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Products Found in DB");
			response.setProducts(products);
			
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Products Not Found in DB");
			
		}
		return response;
		
	}
	@PostMapping(path = "/placeorder",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public MedicalStoreResponse placeOrder(@RequestBody OrderInfo orderInfo) {
		MedicalStoreResponse response = new MedicalStoreResponse();
		OrderInfo order = service.placeOrder(orderInfo);
		if(order!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Order Placed Successfully");
			response.setOrder(order);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Order Not Placed Successfully");
		}
		return response;
	}
	@GetMapping(path = "/searchproducts/{searchkey}",
			produces =  MediaType.APPLICATION_JSON_VALUE)
	public MedicalStoreResponse search(@PathVariable("searchkey") String searchkey) {
		MedicalStoreResponse response = new MedicalStoreResponse();
		List<ProductInfo> products = service.search(searchkey);
		if(products!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Products Found in DB");
			response.setProducts(products);
			
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Products Not Found in DB");
			
		}
		return response;
		
	}
	@PostMapping(path = "/editproduct",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public MedicalStoreResponse editProduct(@RequestBody ProductInfo productInfo) {
		MedicalStoreResponse response = new MedicalStoreResponse();
		if(service.editProduct(productInfo)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Product Modified in DB");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Product Not Modified in DB");
		}
		return response;
	}
	@DeleteMapping(path = "/deleteproduct",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public MedicalStoreResponse deleteProduct(@RequestBody ProductInfo productInfo) {
		MedicalStoreResponse response = new MedicalStoreResponse();
		if(service.deleteProduct(productInfo)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Product Deleted from the DB");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Product Not Deleted from DB");
		}
		return response;
	}
	@DeleteMapping(path = "/deleteuser",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public MedicalStoreResponse deleteUser(@RequestBody UserInfo userInfo) {
		MedicalStoreResponse response = new MedicalStoreResponse();
		if(service.deleteUser(userInfo)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("User Removed from DB");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("User Not Removed from DB");
		}
		return response;
	}
}
