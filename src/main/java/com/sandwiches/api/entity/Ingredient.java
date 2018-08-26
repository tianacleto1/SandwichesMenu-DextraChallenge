package com.sandwiches.api.entity;

import com.sandwiches.api.entity.enums.IngredientType;

public class Ingredient {
	
	public Ingredient(IngredientType type, int quantity) {
		this.ingredientType = type;
		this.quantity = quantity;
	}
	
	private IngredientType ingredientType;
	private int quantity;

	public IngredientType getIngredientType() {
		return ingredientType;
	}
	
	public void setIngredientType(IngredientType ingredientType) {
		this.ingredientType = ingredientType;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
