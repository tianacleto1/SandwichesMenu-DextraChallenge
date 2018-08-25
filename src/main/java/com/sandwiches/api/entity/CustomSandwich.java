package com.sandwiches.api.entity;

import javax.persistence.Entity;

@Entity
public class CustomSandwich extends Sandwich {

	public CustomSandwich() {
		this.name = "X-Custom";
		this.price = 0.0;
	}
	
	public void addIngredient(Ingredient ingredient) {
		this.ingredients.add(ingredient);
	}
}
