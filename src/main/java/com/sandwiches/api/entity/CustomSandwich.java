package com.sandwiches.api.entity;

public class CustomSandwich extends Sandwich {

	public CustomSandwich() {
		this.code = 14l;
		this.name = "X-Custom";
		this.price = 0.0;
	}
	
	public void addIngredient(Ingredient ingredient) {
		this.ingredients.add(ingredient);
	}
}
