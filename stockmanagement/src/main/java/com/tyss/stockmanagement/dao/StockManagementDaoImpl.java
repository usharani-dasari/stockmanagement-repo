package com.tyss.stockmanagement.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.tyss.stockmanagement.dto.Order_Info;
import com.tyss.stockmanagement.dto.Products_Info;
@Repository
public class StockManagementDaoImpl implements StockManagementDAO {

	@PersistenceUnit
		private EntityManagerFactory factory;
	
	@Override
	public Products_Info addProduct(Products_Info productInfo) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(productInfo);
			transaction.commit();
			return manager.find(Products_Info.class, productInfo.getPid());
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			manager.close();
		}
	}

	@Override
	public boolean modifyProduct(Products_Info productInfo) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			Products_Info product = manager.find(Products_Info.class, productInfo.getPid());
			product.setCategory(productInfo.getCategory());
			product.setCompany(productInfo.getCompany());
			product.setGst(productInfo.getGst());
			product.setName(productInfo.getName());
			product.setQuantity(productInfo.getQuantity());
			product.setPrice(productInfo.getPrice());
			transaction.commit();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			manager.close();
		}
	}

	@Override
	public List<Products_Info> getAllProducts() {
		EntityManager manager = factory.createEntityManager();
		String jpql = "from Products_Info";
		TypedQuery<Products_Info> query = manager.createQuery(jpql, Products_Info.class);
		List<Products_Info> list = query.getResultList();
		return list; 
	}

	@Override
	public Order_Info addProductToCart(Order_Info orderInfo) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		List<Products_Info> products = orderInfo.getOrderedProducts();
		double totalPrice = 0.0;
		double totalPriceWithGst = 0.0;
		double totalGst = 0.0;
		Iterator<Products_Info> iterator = products.iterator();
		while(iterator.hasNext()) {
			Products_Info product = iterator.next();
			Products_Info product1 = manager.find(Products_Info.class, product.getPid());
			totalPrice += product1.getPrice();
			totalGst += product1.getGst();
			product1.setQuantity(product1.getQuantity()-1);
		}
		totalPriceWithGst = totalPrice + totalGst;
		orderInfo.setTotal_Price(totalPrice);
		orderInfo.setTotal_Price_With_Gst(totalPriceWithGst);
		try {
			manager.persist(orderInfo);
			transaction.commit();
			Order_Info order = manager.find(Order_Info.class, orderInfo.getOid());
			return order;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Products_Info> search(String searchKey) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "from Products_Info where name=:searchKey OR company=:searchKey OR category=:searchKey";
		    TypedQuery<Products_Info> query = manager.createQuery(jpql,Products_Info.class); 
		    
		    query.setParameter("searchKey", searchKey);
		    return query.getResultList();     
	}

}
