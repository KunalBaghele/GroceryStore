package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.models.GroceryInfo;
import com.app.repository.GroceryAmountsRepository;
import com.app.serviceImpl.GroceryInfoServiceImpl;

@RestController
@RequestMapping("/api/groceries")
@CrossOrigin
public class GroceryInfoController {

	@Autowired
	private GroceryInfoServiceImpl groceryInfoService;
	@Autowired
	private GroceryAmountsRepository groceryAmountRepository;

	@GetMapping
	public ResponseEntity<List<GroceryInfo>> getAllGroceries() {
		try {
			List<GroceryInfo> groceries = groceryInfoService.getAllGroceries();
			return new ResponseEntity<>(groceries, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping
	public ResponseEntity<GroceryInfo> addGrocery(@RequestBody GroceryInfo grocery) {
		System.out.println("info : "+grocery);
		try {
			GroceryInfo addedGrocery = groceryInfoService.addGrocery(grocery);
			return new ResponseEntity<>(addedGrocery, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<GroceryInfo> byId(@PathVariable int id) {
		GroceryInfo groceryInfo = groceryInfoService.getGroceryById(id).orElse(null);
		return new ResponseEntity<>(groceryInfo, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<GroceryInfo> updateGrocery(@PathVariable int id, @RequestBody GroceryInfo grocery) {
		GroceryInfo updatedGrocery = groceryInfoService.updateGrocery(id, grocery);
		return new ResponseEntity<>(updatedGrocery, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteGrocery(@PathVariable int id) {
		System.out.println(id);
		groceryInfoService.deleteGrocery(id);
		groceryAmountRepository.deleteById(id);
		String message = "Grocery with Id " + id + " deleted successfully.";
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	@GetMapping("/byType")
	public ResponseEntity<List<GroceryInfo>> searchByType(@RequestParam(value = "groceryType") String groceryType) {
		List<GroceryInfo> searchedGroceryType = groceryInfoService.searchByType(groceryType);
		return new ResponseEntity<>(searchedGroceryType, HttpStatus.OK);
	}
}
