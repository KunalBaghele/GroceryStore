package com.app.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "GROCERY_SOURCE")
public class GrocerySource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SOURCE_ID")
    private int sourceId;

    @Column(name = "STATE_NAME")
    private String stateName;
    
    

    @OneToMany(mappedBy = "grocerySource", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<GroceryInfo> groceryInfoList;

	public int getSourceId() {
		return sourceId;
	}

	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public List<GroceryInfo> getGroceryInfoList() {
		return groceryInfoList;
	}

	public void setGroceryInfoList(List<GroceryInfo> groceryInfoList) {
		this.groceryInfoList = groceryInfoList;
	}

    
}
