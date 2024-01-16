package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.models.GroceryInfo;

public interface GroceryInfoRepository extends JpaRepository<GroceryInfo, Integer> {
	
//	@Query("SELECT g FROM GroceryInfo g WHERE g.groceryType = :groceryType")
//	List<GroceryInfo> findByGroceryType(@Param("groceryType") String groceryType);
	
	@Query("SELECT g FROM GroceryInfo g WHERE g.groceryType LIKE %:groceryType%")
	List<GroceryInfo> findByGroceryType(@Param("groceryType") String groceryType);

}
