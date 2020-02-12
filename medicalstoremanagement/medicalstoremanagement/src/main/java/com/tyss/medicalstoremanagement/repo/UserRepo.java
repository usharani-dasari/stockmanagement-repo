package com.tyss.medicalstoremanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.medicalstoremanagement.dto.UserInfo;

public interface UserRepo  extends JpaRepository<UserInfo, Integer>{
	
	public UserInfo findByEmail(String email);

}
