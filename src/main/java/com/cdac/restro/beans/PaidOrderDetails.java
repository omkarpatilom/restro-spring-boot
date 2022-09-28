package com.cdac.restro.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "paid_order_details_tab")
public class PaidOrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderID;
	private Integer userID;
//	private Integer itemID;
	private Integer priceWithQuantity;

	public PaidOrderDetails(Integer orderID, Integer userID, Integer priceWithQuantity) {
		super();
		this.orderID = orderID;
		this.userID = userID;
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

//	public Integer getItemID() {
//		return itemID;
//	}
//
//	public void setItemID(Integer itemID) {
//		this.itemID = itemID;
//	}

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
		return "PaidOrderDetails [orderID=" + orderID + ", userID=" + userID + ", priceWithQuantity="
				+ priceWithQuantity + "]";
	}

	public PaidOrderDetails() {
		super();
	}

}
