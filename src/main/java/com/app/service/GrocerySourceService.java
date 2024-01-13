package com.app.service;

import java.util.List;

import com.app.models.GrocerySource;

public interface GrocerySourceService {
	List<GrocerySource> getAllSources();
	GrocerySource getByName(String stateName);
}
