package com.sandwiches.api.entity;

import com.sandwiches.api.entity.enums.IngredientType;

public class XEgg extends Sandwich {

	public XEgg() {
		this.code = 12l;
		this.name = "X-Egg";
		this.ingredients.add(new Ingredient(IngredientType.OVO, 1));
	    this.ingredients.add(new Ingredient(IngredientType.HAMBURGER, 1));
	    this.ingredients.add(new Ingredient(IngredientType.QUEIJO, 1));
	}
}
