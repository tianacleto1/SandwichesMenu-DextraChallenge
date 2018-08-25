package com.sandwiches.api.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.sandwiches.api.entity.enums.IngredientType;

@Entity
@DiscriminatorValue("x_bacon")
public class XBacon extends Sandwich {

	public XBacon() {
		this.name = "X-Bacon";
		this.ingredients.add(new Ingredient(11l, IngredientType.BACON, 1));
	    this.ingredients.add(new Ingredient(12l, IngredientType.HAMBURGER, 1));
	    this.ingredients.add(new Ingredient(14l, IngredientType.QUEIJO, 1));
	    this.price = calculatePrice();
	}
}
