package com.tyss.medicalstoremanagement.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.tyss.medicalstoremanagement.dto.ProductInfo;

public interface ProductRepo extends JpaRepository<ProductInfo, Integer>{
	@Query("from ProductInfo where pName=:searchKey OR company=:searchKey OR category=:searchKey")
	public List<ProductInfo> search(String searchKey);
	@Transactional
	@Modifying
	@Query("update ProductInfo set pName=:pName, company=:company,category=:category,"
			+ "ptype=:ptype,price=:price,quantity=:quantity,description=:description,"
			+ "pImage=:pImage where pid=:pid")
	public void update(String pName,String company,String category,String ptype,
			         double price,int quantity,String description,String pImage,int pid);
	@Transactional
	@Modifying
	@Query("update ProductInfo set quantity=:quantity where pid=:pid")
	public void updateQuantity(int quantity,int pid);

}
