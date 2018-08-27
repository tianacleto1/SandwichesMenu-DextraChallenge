package com.sandwiches.api.entity;

import java.util.List;

public class Order {

	private Long code;

	private List<Sandwich> sandwiches;
	private double total;
	
	public Long getCode() {
		return code;
	}
	
	public void setCode(Long code) {
		this.code = code;
	}
	
	public List<Sandwich> getSandwiches() {
		return sandwiches;
	}
	
	public void setSandwiches(List<Sandwich> sandwiches) {
		this.sandwiches = sandwiches;
	}
	
	public double getTotal() {
		return total;
	}
	
	public void calculateTotal(double total) {
		sandwiches.forEach(sandwich -> this.total = sandwich.getPrice());
	}
}
