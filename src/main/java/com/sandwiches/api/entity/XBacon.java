package com.sandwiches.api.entity;

import com.sandwiches.api.entity.enums.IngredientType;

public class XBacon extends Sandwich {

	public XBacon() {
		this.code = 10l;
		this.name = "X-Bacon";
		Ingredient bacon = new Ingredient(IngredientType.BACON, 1);
		Ingredient hamburguer = new Ingredient(IngredientType.HAMBURGER, 1);
		Ingredient queijo = new Ingredient(IngredientType.QUEIJO, 1);
		
		this.ingredients.add(bacon);
	    this.ingredients.add(hamburguer);
	    this.ingredients.add(queijo);
	}
}
