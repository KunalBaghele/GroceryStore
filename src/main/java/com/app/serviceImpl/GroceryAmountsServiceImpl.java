package com.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.models.GroceryAmounts;
import com.app.repository.GroceryAmountsRepository;
import com.app.service.GroceryAmountsService;

@Service
public class GroceryAmountsServiceImpl implements GroceryAmountsService {

    @Autowired
    private GroceryAmountsRepository groceryAmountsRepository;

    @Override
    public List<GroceryAmounts> getAllGroceryAmounts() {
        return groceryAmountsRepository.findAll();
    }

    @Override
    public GroceryAmounts getGroceryAmountById(int groceryAmountId) {
        return groceryAmountsRepository.findById(groceryAmountId).orElse(null);
    }

    @Override
    public GroceryAmounts addGroceryAmount(GroceryAmounts groceryAmount) {
        return groceryAmountsRepository.save(groceryAmount);
    }

    @Override
    public GroceryAmounts updateTotalCost(int groceryAmountId, float newTotalCost) {
        groceryAmountsRepository.updateTotalCost(groceryAmountId, newTotalCost);
        return getGroceryAmountById(groceryAmountId);
    }

    @Override
    public void deleteGroceryAmount(int groceryAmountId) {
        groceryAmountsRepository.deleteById(groceryAmountId);
    }
}
