package com.sandwiches.api.entity;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sandwiches.api.entity.enums.IngredientType;

@Entity
public class Ingredient {
	
	public Ingredient() {}
	
	public Ingredient(Long code, IngredientType type, int quantity) {
		this.code = code;
		this.ingredientType = type;
		this.quantity = quantity;
	}
	
	@Id
	private Long code;
	
	@Enumerated(EnumType.STRING)
	private IngredientType ingredientType;
	private int quantity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sandwich")
	@JsonIgnore
	private Sandwich sandwich;
	
	public Long getCode() {
		return code;
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

	public Sandwich getSandwich() {
		return this.sandwich;
	}

	public void setSandwich(Sandwich sandwich) {
		this.sandwich = sandwich;
	}
}
