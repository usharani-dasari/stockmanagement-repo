package com.tyss.medicalstoremanagement.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tyss.medicalstoremanagement.dto.OrderInfo;
import com.tyss.medicalstoremanagement.dto.ProductInfo;

public interface OrderInfoRepo extends JpaRepository<OrderInfo,Integer> {
	

}
