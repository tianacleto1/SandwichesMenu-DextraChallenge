package com.sandwiches.api.entity.enums;

public enum IngredientType {

	ALFACE("alface", 0.40),
	BACON("bacon", 2.00),
	HAMBURGER("hamburger", 3.00),
	OVO("ovo", 0.80),
	QUEIJO("queijo", 1.50);
	
	private String name;
	private double value;
	
	private IngredientType(String name, double value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public double getValue() {
		return value;
	}
}
