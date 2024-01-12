package com.app.service;

import java.util.List;

import com.app.models.GroceryAmounts;

public interface GroceryAmountsService {
	List<GroceryAmounts> getAllGroceryAmounts();
    GroceryAmounts getGroceryAmountById(int groceryAmountId);
    GroceryAmounts addGroceryAmount(GroceryAmounts groceryAmount);
    GroceryAmounts updateTotalCost(int groceryAmountId, float newTotalCost);
    void deleteGroceryAmount(int groceryAmountId);
}
