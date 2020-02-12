package com.tyss.stockmanagement.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="order_info")
public class Order_Info {
	@Id
	@GeneratedValue
	@Column
	private int oid;
	@Column
	private double total_Price;
	@Column
	private double total_Price_With_Gst;
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "order_history_info",joinColumns = @JoinColumn(name="oid"),
											inverseJoinColumns = @JoinColumn(name="pid"))
	private List<Products_Info> orderedProducts;
	
	
	public List<Products_Info> getOrderedProducts() {
		return orderedProducts;
	}
	public void setOrderedProducts(List<Products_Info> orderedProducts) {
		this.orderedProducts = orderedProducts;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public double getTotal_Price() {
		return total_Price;
	}
	public void setTotal_Price(double total_Price) {
		this.total_Price = total_Price;
	}
	public double getTotal_Price_With_Gst() {
		return total_Price_With_Gst;
	}
	public void setTotal_Price_With_Gst(double total_Price_With_Gst) {
		this.total_Price_With_Gst = total_Price_With_Gst;
	}
	
	

}
