package com.sandwiches.api.entity;

public class Ingredient {
	
	private Long id;
	private IngredientType ingredientType;
	private int quantity;
	
	public Long getId() {
		return id;
	}
	
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
