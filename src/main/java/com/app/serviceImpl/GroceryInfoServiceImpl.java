package com.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.models.GroceryAmounts;
import com.app.models.GroceryInfo;
import com.app.models.GrocerySource;
import com.app.repository.GroceryInfoRepository;
import com.app.repository.GrocerySourceRepository;
import com.app.service.GroceryInfoService;

@Service
public class GroceryInfoServiceImpl implements GroceryInfoService {

    @Autowired
    private GroceryInfoRepository groceryInfoRepository;
    @Autowired
    private GrocerySourceRepository grocerySourceRepository;

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
    public GroceryInfo addGrocery(GroceryInfo grocery, int stateId) {
    	GroceryAmounts groceryAmount=new GroceryAmounts();
        // Fetch the selected state from the repository
        GrocerySource grocerySource = grocerySourceRepository.findById(stateId).orElseThrow(() -> new RuntimeException("State not found"));

        // Set the selected state for the grocery
        grocery.setGrocerySource(grocerySource);
        
        // Calculate and set the total cost
//        if (grocery.getCostPerItem() != null && groceryAmount.getItemsAvailable() != null) {
        	groceryAmount.setTotalCostOfItems(grocery.getCostPerItem() * groceryAmount.getItemsAvailable());
//        }

        // Save the grocery with the calculated total cost
        return groceryInfoRepository.save(grocery);
    }

    @Override
    public GroceryInfo updateGrocery(int id,GroceryInfo grocery) {
        return groceryInfoRepository.save(grocery);
    }

    @Override
    public void deleteGrocery(int groceryId) {
        groceryInfoRepository.deleteById(groceryId);
    }
}
