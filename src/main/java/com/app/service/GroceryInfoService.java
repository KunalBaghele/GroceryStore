package com.app.service;

import java.util.List;

import com.app.models.GroceryInfo;

public interface GroceryInfoService {
    List<GroceryInfo> getAllGroceries();
    List<GroceryInfo> getGroceriesByState(String stateName);
    GroceryInfo getGroceryById(int groceryId);
    GroceryInfo addGrocery(GroceryInfo grocery);
    GroceryInfo updateGrocery(GroceryInfo grocery);
    void deleteGrocery(int groceryId);
}
