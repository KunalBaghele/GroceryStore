package com.app.serviceImpl;

import java.util.List;
import java.util.Optional;

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

	@Override
	public List<GroceryInfo> getAllGroceries() {
		GrocerySource grocerySource = new GrocerySource();
		GroceryAmounts groceryAmount = new GroceryAmounts();
		groceryAmount.getTotalCostOfItems();
		grocerySource.getStateName();
		List<GroceryInfo> groceries = groceryInfoRepository.findAll();
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

			// Calculate totalCostOfItems costPerItem and itemsAvailable
			float totalCost = (float) costPerItem * itemsAvailable;

			// Create a new GroceryAmounts entity
			groceryAmount.setItemsAvailable(itemsAvailable);
			groceryAmount.setTotalCostOfItems(totalCost);
			// Save the GroceryAmounts entity
			groceryAmountsRepository.save(groceryAmount);
			grocery.setGroceryAmounts(groceryAmount);

			// Check if GrocerySource with the given state exists
			GrocerySource existingSource = grocerySourceRepository.findByName(state);

			if (existingSource != null) {
				// If exists use the existing GrocerySource
				grocerySource = existingSource;
			} else {
				// If not exists create a new GrocerySource and save
				grocerySource.setStateName(state);
				grocerySourceRepository.save(grocerySource);
			}
			grocery.setGrocerySource(grocerySource);

			// Save the GroceryInfo entity
			grocery.setCostPerItem(costPerItem);
			grocery.setGroceryName(groceryName);
			return groceryInfoRepository.save(grocery);
		} catch (Exception e) {
			e.printStackTrace(); 
			throw new RuntimeException("Failed to add grocery", e);
		}
	}

	@Override
	public Optional<GroceryInfo> getGroceryById(int groceryId) {
		Optional<GroceryInfo> groceryInfo = groceryInfoRepository.findById(groceryId);
		return groceryInfo;
	}

	@Override
	public GroceryInfo updateGrocery(int id, GroceryInfo updatedGrocery) {
		// Check if the grocery with the given ID exists
		Optional<GroceryInfo> existingGroceryOptional = groceryInfoRepository.findById(id);

		if (existingGroceryOptional.isPresent()) {
			GroceryInfo existingGrocery = existingGroceryOptional.get();

			// Update the fields with the new values
			existingGrocery.setGroceryName(updatedGrocery.getGroceryName());
			existingGrocery.setCostPerItem(updatedGrocery.getCostPerItem());

			// Update itemsAvailable and groceryAmounts
			if (updatedGrocery.getGroceryAmounts() != null) {
				existingGrocery.getGroceryAmounts()
						.setItemsAvailable(updatedGrocery.getGroceryAmounts().getItemsAvailable());

				// Recalculate total cost based on the new itemsAvailable
				float newTotalCost = (float) updatedGrocery.getCostPerItem()
						* updatedGrocery.getGroceryAmounts().getItemsAvailable();
				existingGrocery.getGroceryAmounts().setTotalCostOfItems(newTotalCost);
			}

			// Update stateName and grocerySource
			if (updatedGrocery.getGrocerySource() != null) {
				System.out.println(updatedGrocery.getGrocerySource().getSourceId());
				int newStateId = updatedGrocery.getGrocerySource().getSourceId();

				// Check if the state ID is different
				if (existingGrocery.getGrocerySource().getSourceId() != newStateId) {
					// Check if GrocerySource with the given state ID already exists
					Optional<GrocerySource> existingSourceState = grocerySourceRepository.findById(newStateId);

					if (existingSourceState.isPresent()) {
						// If exists use the existing GrocerySource
						existingGrocery.setGrocerySource(existingSourceState.get());
					} else {
						// If not exists create a new GrocerySource and save
						GrocerySource newSource = new GrocerySource();
						newSource.setSourceId(newStateId);
						newSource.setStateName(updatedGrocery.getGrocerySource().getStateName());
						grocerySourceRepository.save(newSource);
						existingGrocery.setGrocerySource(newSource);
					}
				}
			}
			// Save the updated GroceryInfo entity
			return groceryInfoRepository.save(existingGrocery);
		} else {
			throw new RuntimeException("Grocery not found with ID: " + id);
		}
	}

	@Override
	public void deleteGrocery(int groceryId) {
		groceryInfoRepository.deleteById(groceryId);
	}

	@Override
	public List<GroceryInfo> searchByType(String groceryType) {
		List<GroceryInfo> searchedGrocery = groceryInfoRepository.findByGroceryType(groceryType);
		return searchedGrocery;
	}
}
