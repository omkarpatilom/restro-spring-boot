package com.cdac.restro.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_details_tab")
public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderID;
	private Integer userID;
	private Integer itemID;
	private Integer priceWithQuantity;
	private Integer itemQuantity;
	private Integer itemPrice;
	private String payStatus;
	
	
	

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public Integer getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Integer itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Integer getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(Integer itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public OrderDetails(Integer orderID, Integer userID, Integer itemID, Integer priceWithQuantity) {
		super();
		this.orderID = orderID;
		this.userID = userID;
		this.itemID = itemID;
		this.priceWithQuantity = priceWithQuantity;
	}

	public Integer getOrderID() {
		return orderID;
	}

	public void setOrderID() {
		this.orderID = this.userID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Integer getItemID() {
		return itemID;
	}

	public void setItemID(Integer itemID) {
		this.itemID = itemID;
	}

	

	public Integer getPriceWithQuantity() {
		return priceWithQuantity;
	}

	public void setPriceWithQuantity(Integer priceWithQuantity) {
		this.priceWithQuantity = priceWithQuantity;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	

	@Override
	public String toString() {
		return "OrderDetails [orderID=" + orderID + ", userID=" + userID + ", itemID=" + itemID + ", priceWithQuantity="
				+ priceWithQuantity + ", itemQuantity=" + itemQuantity + ", itemPrice=" + itemPrice + ", payStatus="
				+ payStatus + "]";
	}

	public OrderDetails() {
		super();
	}

}
