package com.sandwiches.api.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	
	@OneToMany
	@ElementCollection(targetClass = Integer.class)
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
		sandwiches.forEach(s -> this.total += s.calculatePrice());
	}
}
