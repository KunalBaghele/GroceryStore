package com.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.models.GroceryAmounts;
import com.app.models.GroceryInfo;
import com.app.models.GrocerySource;
import com.app.repository.GroceryInfoRepository;
import com.app.service.GroceryInfoService;

@Service
public class GroceryInfoServiceImpl implements GroceryInfoService {

    @Autowired
    private GroceryInfoRepository groceryInfoRepository;
    

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
