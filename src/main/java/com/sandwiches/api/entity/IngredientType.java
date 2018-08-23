package com.sandwiches.api.entity;

public enum IngredientType {

	ALFACE("alface", 0.40),
	BACON("bacon", 2.00),
	CARNE("carne", 3.00),
	OVO("ovo", 0.80),
	QUEIJO("queijo", 1.50);
	
	private String name;
	private double price;
	
	private IngredientType(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
}
