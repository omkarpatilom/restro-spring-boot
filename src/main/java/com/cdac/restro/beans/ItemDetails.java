package com.cdac.restro.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item_details_tab")
public class ItemDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer itemID;
	private String itemName;
	private String itemCategory;
	private Integer price;

	public ItemDetails() {
		super();
	}

	@Override
	public String toString() {
		return "ItemDetails [itemID=" + itemID + ", itemName=" + itemName + ", itemCategory=" + itemCategory
				+ ", price=" + price + "]";
	}

	public ItemDetails(Integer itemID, String itemName, String itemCategory, Integer price) {
		super();
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemCategory = itemCategory;
		this.price = price;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public Integer getItemID() {
		return itemID;
	}

	public void setItemID(Integer itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}
