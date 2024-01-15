package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.models.GrocerySource;
import com.app.serviceImpl.GrocerySourceServiceImpl;

@RestController
@RequestMapping("/api/sources")
@CrossOrigin
public class GrocerySourceController {
	
	@Autowired
	GrocerySourceServiceImpl grocerySourceServiceImpl;
	
	@GetMapping("/states")
	public List<GrocerySource> getAllStates(){
		List<GrocerySource> states=grocerySourceServiceImpl.getAllSources();
		return states;
	}
}
