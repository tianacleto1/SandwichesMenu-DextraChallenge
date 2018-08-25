package com.sandwiches.api.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.sandwiches.api.entity.enums.IngredientType;

@Entity
@DiscriminatorValue("x_burger")
public class XBurger extends Sandwich {

	public XBurger() {
		this.name = "X-Burger";
	    this.ingredients.add(new Ingredient(12l, IngredientType.HAMBURGER, 1));
	    this.ingredients.add(new Ingredient(14l, IngredientType.QUEIJO, 1));
	    this.price = calculatePrice();
	}
}
