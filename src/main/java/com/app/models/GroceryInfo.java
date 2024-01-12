package com.app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "GROCERY_INFO")
public class GroceryInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GROCERY_ID")
    private int groceryId;

    @Column(name = "GROCERY_NAME")
    private String groceryName;

    @Column(name = "COST_PER_ITEM")
    private float costPerItem;

    @ManyToOne
    @JoinColumn(name = "GROCERY_AMOUNT_ID")
    private GroceryAmounts groceryAmounts;

    @ManyToOne
    @JoinColumn(name = "SOURCE_ID")
    private GrocerySource grocerySource;

	public int getGroceryId() {
		return groceryId;
	}

	public void setGroceryId(int groceryId) {
		this.groceryId = groceryId;
	}

	public String getGroceryName() {
		return groceryName;
	}

	public void setGroceryName(String groceryName) {
		this.groceryName = groceryName;
	}

	public float getCostPerItem() {
		return costPerItem;
	}

	public void setCostPerItem(float costPerItem) {
		this.costPerItem = costPerItem;
	}

	public GroceryAmounts getGroceryAmounts() {
		return groceryAmounts;
	}

	public void setGroceryAmounts(GroceryAmounts groceryAmounts) {
		this.groceryAmounts = groceryAmounts;
	}

	public GrocerySource getGrocerySource() {
		return grocerySource;
	}

	public void setGrocerySource(GrocerySource grocerySource) {
		this.grocerySource = grocerySource;
	}

    
}

