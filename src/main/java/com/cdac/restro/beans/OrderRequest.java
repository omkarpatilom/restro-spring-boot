package com.cdac.restro.beans;

public class OrderRequest {
	private String itemName;
	private Integer cusID;
	private Integer orderID;
	private Integer itemQuantity;
	private Integer price;
	private Integer itemID;

	public OrderRequest() {

	}

	public Integer getItemID() {
		return itemID;
	}

	public void setItemID(Integer itemID) {
		this.itemID = itemID;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getOrderID() {
		return orderID;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	public Integer getCusID() {
		return cusID;
	}

	public void setCusID(Integer cusID) {
		this.cusID = cusID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(Integer itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	@Override
	public String toString() {
		return "OrderRequest [itemName=" + itemName + ", cusID=" + cusID + ", orderID=" + orderID + ", itemQuantity="
				+ itemQuantity + ", price=" + price + ", itemID=" + itemID + "]";
	}
}