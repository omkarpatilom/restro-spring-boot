package com.cdac.restro.beans;

public class AllPaidUnpaidOrders {
	private Integer orderID;
	private Integer userID;
	private Integer itemID;
	private Integer priceWithQuantity;
	private String payStatus;
	private String userName;

	public Integer getOrderID() {
		return orderID;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
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

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "AllPaidUnpaidOrders [orderID=" + orderID + ", userID=" + userID + ", itemID=" + itemID
				+ ", priceWithQuantity=" + priceWithQuantity + ", payStatus=" + payStatus + ", userName=" + userName
				+ "]";
	}

}
