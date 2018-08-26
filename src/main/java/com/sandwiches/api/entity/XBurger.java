package com.sandwiches.api.entity;

import com.sandwiches.api.entity.enums.IngredientType;

public class XBurger extends Sandwich {

	public XBurger() {
		this.code = 11l;
		this.name = "X-Burger";
	    this.ingredients.add(new Ingredient(IngredientType.HAMBURGER, 1));
	    this.ingredients.add(new Ingredient(IngredientType.QUEIJO, 1));
	}
}
