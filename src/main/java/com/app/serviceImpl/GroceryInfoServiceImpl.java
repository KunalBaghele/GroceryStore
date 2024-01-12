package com.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.models.GroceryInfo;
import com.app.repository.GroceryInfoRepository;
import com.app.service.GroceryInfoService;

@Service
public class GroceryInfoServiceImpl implements GroceryInfoService {

    @Autowired
    private GroceryInfoRepository groceryInfoRepository;

    @Override
    public List<GroceryInfo> getAllGroceries() {
        return groceryInfoRepository.findAll();
    }

    @Override
    public List<GroceryInfo> getGroceriesByState(String stateName) {
        return groceryInfoRepository.findByGrocerySourceStateName(stateName);
    }

    @Override
    public GroceryInfo getGroceryById(int groceryId) {
        return groceryInfoRepository.findById(groceryId).orElse(null);
    }

    @Override
    public GroceryInfo addGrocery(GroceryInfo grocery) {
        return groceryInfoRepository.save(grocery);
    }

    @Override
    public GroceryInfo updateGrocery(GroceryInfo grocery) {
        return groceryInfoRepository.save(grocery);
    }

    @Override
    public void deleteGrocery(int groceryId) {
        groceryInfoRepository.deleteById(groceryId);
    }
}
