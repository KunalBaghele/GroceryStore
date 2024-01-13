package com.app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "GROCERY_AMOUNTS")
public class GroceryAmounts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GROCERY_AMOUNT_ID")
	private int groceryAmountId;

	@Column(name = "ITEMS_AVAILABLE")
	private int itemsAvailable;

	@Column(name = "TOTAL_COST_OF_ITEMS")
	private float totalCostOfItems;

	public int getGroceryAmountId() {
		return groceryAmountId;
	}

	public void setGroceryAmountId(int groceryAmountId) {
		this.groceryAmountId = groceryAmountId;
	}

	public int getItemsAvailable() {
		return itemsAvailable;
	}

	public void setItemsAvailable(int itemsAvailable) {
		this.itemsAvailable = itemsAvailable;
	}

	public float getTotalCostOfItems() {
		return totalCostOfItems;
	}

	public void setTotalCostOfItems(float totalCostOfItems) {
		this.totalCostOfItems = totalCostOfItems;
	}

	@Override
	public String toString() {
		return "GroceryAmounts [groceryAmountId=" + groceryAmountId + ", itemsAvailable=" + itemsAvailable
				+ ", totalCostOfItems=" + totalCostOfItems + ", groceryInfoList=" + "]";
	}

}
