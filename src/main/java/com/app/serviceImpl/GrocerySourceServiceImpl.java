package com.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.models.GrocerySource;
import com.app.repository.GrocerySourceRepository;
import com.app.service.GrocerySourceService;

@Service
public class GrocerySourceServiceImpl implements GrocerySourceService{
	
	@Autowired
    private GrocerySourceRepository grocerySourceRepository;

	@Override
	public List<GrocerySource> getAllSources() {
		grocerySourceRepository.findAll();
		return null;
	}

	@Override
	public GrocerySource getByName(String stateName) {
		grocerySourceRepository.findByName(stateName);
		return null;
	}

}
