package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.models.GroceryAmounts;

public interface GroceryAmountsRepository extends JpaRepository<GroceryAmounts, Integer> {
    @Modifying
    @Query("UPDATE GroceryAmounts g SET g.totalCostOfItems = :newTotalCost WHERE g.groceryAmountId = :amountId")
    int updateTotalCost(@Param("amountId") int amountId, @Param("newTotalCost") float newTotalCost);
}
