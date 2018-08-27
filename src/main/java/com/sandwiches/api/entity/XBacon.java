package com.sandwiches.api.entity;

import com.sandwiches.api.entity.enums.IngredientType;

public class XBacon extends Sandwich {

	public XBacon() {
		this.code = 10l;
		this.name = "X-Bacon";
		this.ingredients.add(new Ingredient(IngredientType.BACON, 1));
		this.ingredients.add(new Ingredient(IngredientType.HAMBURGER, 1));
		this.ingredients.add(new Ingredient(IngredientType.QUEIJO, 1));
	}
}
