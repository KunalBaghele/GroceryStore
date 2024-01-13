package com.app.service;

import java.util.List;

import com.app.models.GroceryInfo;

public interface GroceryInfoService {
    List<GroceryInfo> getAllGroceries();
    GroceryInfo addGrocery(GroceryInfo grocery);
    GroceryInfo updateGrocery(int id,GroceryInfo grocery);
    void deleteGrocery(int groceryId);
}
