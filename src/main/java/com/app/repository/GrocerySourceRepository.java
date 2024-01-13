package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.models.GrocerySource;

public interface GrocerySourceRepository extends JpaRepository<GrocerySource, Integer>{

}
