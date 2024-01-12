package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.models.GrocerySource;
import com.app.service.GrocerySourceService;

@RestController
@RequestMapping("/api/grocery-sources")
public class GrocerySourceController {

    @Autowired
    private GrocerySourceService grocerySourceService;

    @GetMapping
    public ResponseEntity<List<GrocerySource>> getAllGrocerySources() {
        List<GrocerySource> grocerySources = grocerySourceService.getAllGrocerySources();
        return new ResponseEntity<>(grocerySources, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrocerySource> getGrocerySourceById(@PathVariable int id) {
        GrocerySource grocerySource = grocerySourceService.getGrocerySourceById(id);
        return new ResponseEntity<>(grocerySource, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GrocerySource> addGrocerySource(@RequestBody GrocerySource grocerySource) {
        GrocerySource addedGrocerySource = grocerySourceService.addGrocerySource(grocerySource);
        return new ResponseEntity<>(addedGrocerySource, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrocerySource(@PathVariable int id) {
        grocerySourceService.deleteGrocerySource(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

