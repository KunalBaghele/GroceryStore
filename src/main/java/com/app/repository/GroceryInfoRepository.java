package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.models.GroceryInfo;

public interface GroceryInfoRepository extends JpaRepository<GroceryInfo, Integer> {
	@Query("SELECT gi FROM GroceryInfo gi JOIN FETCH gi.groceryAmounts ga JOIN FETCH gi.grocerySource gs")
    List<GroceryInfo> findAllW();
}
