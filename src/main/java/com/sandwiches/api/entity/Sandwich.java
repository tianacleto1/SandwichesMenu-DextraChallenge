package com.sandwiches.api.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "sandwich_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Sandwich {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int code;
	protected String name;
	
	@OneToMany(mappedBy = "sandwich")
	protected List<Ingredient> ingredients = new ArrayList<>();
	protected double price;
	
	public double calculatePrice() {
		
		ingredients.forEach(in -> price += in.getIngredientType().getPrice());
		
		return price;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}

