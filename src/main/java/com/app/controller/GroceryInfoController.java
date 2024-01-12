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

import com.app.models.GroceryInfo;
import com.app.service.GroceryInfoService;

@RestController
@RequestMapping("/api/groceries")
public class GroceryInfoController {

    @Autowired
    private GroceryInfoService groceryInfoService;

    @GetMapping
    public ResponseEntity<List<GroceryInfo>> getAllGroceries() {
        List<GroceryInfo> groceries = groceryInfoService.getAllGroceries();
        return new ResponseEntity<>(groceries, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroceryInfo> getGroceryById(@PathVariable int id) {
        GroceryInfo grocery = groceryInfoService.getGroceryById(id);
        return new ResponseEntity<>(grocery, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GroceryInfo> addGrocery(@RequestBody GroceryInfo grocery,
                                                  @RequestParam(name = "stateId") int stateId) {
        GroceryInfo addedGrocery = groceryInfoService.addGrocery(grocery, stateId);
        return new ResponseEntity<>(addedGrocery, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroceryInfo> updateGrocery(@PathVariable int id, @RequestBody GroceryInfo grocery) {
        // Assuming you have a service method to update grocery by ID
        GroceryInfo updatedGrocery = groceryInfoService.updateGrocery(id, grocery);
        return new ResponseEntity<>(updatedGrocery, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrocery(@PathVariable int id) {
        groceryInfoService.deleteGrocery(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
