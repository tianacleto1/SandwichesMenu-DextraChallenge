package com.sandwiches.api.repository;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.sandwiches.api.entity.Ingredient;
import com.sandwiches.api.entity.Order;
import com.sandwiches.api.entity.Sandwich;

@Component
public class Database {
	
	private HashMap<String, Ingredient> ingredients;
    private HashMap<Long, Sandwich> sandwiches;
    private HashMap<Long, Order> orders;

    public Database(){
        this.ingredients = new HashMap<>();
        this.sandwiches = new HashMap<>();
        this.orders = new HashMap<>();
    }

	public HashMap<String, Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(HashMap<String, Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public HashMap<Long, Sandwich> getSandwiches() {
		return sandwiches;
	}

	public void setSandwiches(HashMap<Long, Sandwich> sandwiches) {
		this.sandwiches = sandwiches;
	}

	public HashMap<Long, Order> getOrders() {
		return orders;
	}

	public void setOrders(HashMap<Long, Order> orders) {
		this.orders = orders;
	}
    
    
}
