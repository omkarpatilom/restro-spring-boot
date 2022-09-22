package com.cdac.restro.beans;

public class CustomerOrderDetails {
	private Integer orderID;
	private Integer cusID;
	private Integer totalPrice;
	private String itemName;
	private String cusName;
	private Integer itemQuantity;
	private Integer itemPrice;

	
	public Integer getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(Integer itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public Integer getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Integer itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Integer getCusID() {
		return cusID;
	}

	public void setCusID(Integer cusID) {
		this.cusID = cusID;
	}

	public Integer getOrderID() {
		return orderID;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	@Override
	public String toString() {
		return "CustomerOrderDetails [orderID=" + orderID + ", totalPrice=" + totalPrice + ", itemName=" + itemName
				+ ", cusName=" + cusName + "]";
	}

	public CustomerOrderDetails() {
		// TODO Auto-generated constructor stub
	}
}
