package com.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.models.GroceryAmounts;
import com.app.models.GroceryInfo;
import com.app.models.GrocerySource;
import com.app.repository.GroceryAmountsRepository;
import com.app.repository.GroceryInfoRepository;
import com.app.repository.GrocerySourceRepository;
import com.app.service.GroceryInfoService;

@Service
public class GroceryInfoServiceImpl implements GroceryInfoService {

	@Autowired
    private GroceryInfoRepository groceryInfoRepository;

    @Autowired
    private GroceryAmountsRepository groceryAmountsRepository;

    @Autowired
    private GrocerySourceRepository grocerySourceRepository;
    
    @Autowired
    private GrocerySourceServiceImpl grocerySourceServiceImpl;
    

    @Override
    public List<GroceryInfo> getAllGroceries() {
    	GrocerySource grocerySource=new GrocerySource();
    	GroceryAmounts groceryAmount=new GroceryAmounts();
    	groceryAmount.getTotalCostOfItems();
    	grocerySource.getStateName();
    	List<GroceryInfo> groceries=groceryInfoRepository.findAll();
        return groceries;
    }

    @Override
    public GroceryInfo addGrocery(GroceryInfo grocery) {
        GroceryAmounts groceryAmount = new GroceryAmounts();
        GrocerySource grocerySource = new GrocerySource();
        System.out.println(grocery);
        try {
            String groceryName = grocery.getGroceryName();
            float costPerItem = grocery.getCostPerItem();
            int itemsAvailable = grocery.getGroceryAmounts().getItemsAvailable();
            String state = grocery.getGrocerySource().getStateName();

            // Calculate totalCostOfItems based on costPerItem and itemsAvailable
            float totalCost = costPerItem * itemsAvailable;

            // Create a new GroceryAmounts entity
            groceryAmount.setItemsAvailable(itemsAvailable);
            groceryAmount.setTotalCostOfItems(totalCost);
            // Save the GroceryAmounts entity
            groceryAmountsRepository.save(groceryAmount);
            grocery.setGroceryAmounts(groceryAmount);

            // Create a new GrocerySource entity
            GrocerySource existingSource = grocerySourceServiceImpl.getByName(state);
            if (existingSource != null) {
                grocerySource = existingSource;
            } else {
                grocerySource.setStateName(state);
                grocerySourceRepository.save(grocerySource);
            }
            grocery.setGrocerySource(grocerySource);

            // Save the GroceryInfo entity
            grocery.setCostPerItem(costPerItem);
            grocery.setGroceryName(groceryName);
            return groceryInfoRepository.save(grocery);
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception or handle it appropriately
            throw new RuntimeException("Failed to add grocery", e);
        }
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
