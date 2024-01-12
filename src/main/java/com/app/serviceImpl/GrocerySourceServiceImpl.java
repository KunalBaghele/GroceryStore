package com.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.models.GrocerySource;
import com.app.repository.GrocerySourceRepository;
import com.app.service.GrocerySourceService;

@Service
public class GrocerySourceServiceImpl implements GrocerySourceService {

    @Autowired
    private GrocerySourceRepository grocerySourceRepository;

    @Override
    public List<GrocerySource> getAllGrocerySources() {
        return grocerySourceRepository.findAll();
    }

    @Override
    public GrocerySource getGrocerySourceById(int sourceId) {
        return grocerySourceRepository.findById(sourceId).orElse(null);
    }

    @Override
    public GrocerySource addGrocerySource(GrocerySource grocerySource) {
        return grocerySourceRepository.save(grocerySource);
    }

    @Override
    public void deleteGrocerySource(int sourceId) {
        grocerySourceRepository.deleteById(sourceId);
    }
}
