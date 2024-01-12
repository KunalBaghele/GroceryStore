package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.models.GroceryAmounts;
import com.app.service.GroceryAmountsService;

@RestController
@RequestMapping("/api/grocery-amounts")
public class GroceryAmountsController {

    @Autowired
    private GroceryAmountsService groceryAmountsService;

    @GetMapping
    public ResponseEntity<List<GroceryAmounts>> getAllGroceryAmounts() {
        List<GroceryAmounts> groceryAmounts = groceryAmountsService.getAllGroceryAmounts();
        return new ResponseEntity<>(groceryAmounts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroceryAmounts> getGroceryAmountById(@PathVariable int id) {
        GroceryAmounts groceryAmount = groceryAmountsService.getGroceryAmountById(id);
        return new ResponseEntity<>(groceryAmount, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GroceryAmounts> addGroceryAmount(@RequestBody GroceryAmounts groceryAmount) {
        GroceryAmounts addedGroceryAmount = groceryAmountsService.addGroceryAmount(groceryAmount);
        return new ResponseEntity<>(addedGroceryAmount, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroceryAmounts> updateTotalCost(@PathVariable int id,
                                                          @RequestParam(name = "newTotalCost") float newTotalCost) {
        GroceryAmounts updatedGroceryAmount = groceryAmountsService.updateTotalCost(id, newTotalCost);
        return new ResponseEntity<>(updatedGroceryAmount, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroceryAmount(@PathVariable int id) {
        groceryAmountsService.deleteGroceryAmount(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

