package com.tyss.medicalstoremanagement.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_info")
public class OrderInfo {
	@Column
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int oid;
	@Column
	private double totalPrice;
	@ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinTable(name = "order_history_info",joinColumns = @JoinColumn(name="oid"),
											inverseJoinColumns = @JoinColumn(name="pid"))			
	private List<ProductInfo> orderedProducts;
	
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinColumn(name = "uid")
	private UserInfo userInfo;
	
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public List<ProductInfo> getOrderedProducts() {
		return orderedProducts;
	}
	public void setOrderedProducts(List<ProductInfo> orderedProducts) {
		this.orderedProducts = orderedProducts;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
