package com.cdac.restro.beans;

import java.util.List;

public class BillDetails {
	private List<OrderDetails> orders;
	private Integer totalAmount;
	public BillDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public BillDetails(List<OrderDetails> orders, Integer totalAmount) {
		super();
		this.orders = orders;
		this.totalAmount = totalAmount;
	}

	public List<OrderDetails> getOrders() {
		return orders;
	}
	public void setOrders(List<OrderDetails> orders) {
		this.orders = orders;
	}
	public Integer getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}
	@Override
	public String toString() {
		return "BillDetails [orders=" + orders + ", totalAmount=" + totalAmount + "]";
	}
	
	

}
