package com.tyss.stockmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.tyss.stockmanagement.dto.Order_Info;
import com.tyss.stockmanagement.dto.Products_Info;
import com.tyss.stockmanagement.dto.StockResponse;
import com.tyss.stockmanagement.service.StockService;

@RestController
@CrossOrigin(origins ="*", allowCredentials = "true")
public class StockController {
	@Autowired
	private StockService service;
	
	@PostMapping(path = "/addproduct",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public StockResponse addProduct(@RequestBody Products_Info bean) {
		StockResponse response = new StockResponse();
		Products_Info product = service.addProduct(bean);
		if(product!=null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Product added to the Stock");
			response.setProductInfo(product);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Product not added to the Stock");
			
		}
		
		return response;
	}
	@PutMapping(path = "/modifyproduct",
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public StockResponse modifyProduct(@RequestBody Products_Info bean) {
		StockResponse response = new StockResponse();
		if(service.modifyProduct(bean)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Product modified in the Stock");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Product not modified in the Stock");
		}
		return response;
	}
	
	@GetMapping(path = "/getallproducts",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public StockResponse search(){
		
		StockResponse response = new StockResponse();
		List<Products_Info> products = service.getAllProducts();
		if(!products.isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Products found in Stock");
			response.setProducts(products);
			
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Products not found in the Stock");
			
			
		}
		return response;
	}
	
	@PostMapping(path = "/addtocart",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public StockResponse addToCart(@RequestBody Order_Info orderInfo) {
		StockResponse response = new StockResponse();
		Order_Info newOrderInfo = service.addProductToCart(orderInfo);
		if(newOrderInfo!=null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Products added to the cart");
			response.setOrderInfo(newOrderInfo);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("products not added to the cart");
		}
		return response;
	}
	
	@GetMapping(path = "/search/{searchkey}",produces = MediaType.APPLICATION_JSON_VALUE)
	public StockResponse search(@PathVariable("searchkey") String searchkey) {
		StockResponse response = new StockResponse();
		List<Products_Info> products = service.search(searchkey);
		if(!products.isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Products found in Stock");
			response.setProducts(products);
			
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Products not found in the Stock");
			
			
		}
		return response;
	}
	
	}


