package com.app.service;

import java.util.List;

import com.app.models.GrocerySource;

public interface GrocerySourceService {
	List<GrocerySource> getAllGrocerySources();
    GrocerySource getGrocerySourceById(int sourceId);
    GrocerySource addGrocerySource(GrocerySource grocerySource);
    void deleteGrocerySource(int sourceId);
}
