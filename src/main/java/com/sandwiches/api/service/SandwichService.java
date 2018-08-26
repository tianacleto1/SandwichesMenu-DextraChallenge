package com.sandwiches.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandwiches.api.entity.Sandwich;
import com.sandwiches.api.entity.XBacon;
import com.sandwiches.api.entity.XBurger;
import com.sandwiches.api.entity.XEgg;
import com.sandwiches.api.entity.XEggBacon;
import com.sandwiches.api.repository.SandwichRepository;

@Service
public class SandwichService {
	/*
	@Autowired
	IngredientRepository ingredientRep; */
	
	@Autowired
	SandwichRepository sandwichRep;
	
	public List<Sandwich> getMenu() {
		createMenu();
		List<Sandwich> sandwiches = new ArrayList<>(sandwichRep.getAllSandwiches());
		
		sandwiches.forEach(sandwich -> calculatePrice(sandwich));
		
		return sandwiches;
	}
	
	public Sandwich getSandwichByCode(Long code) {
		return sandwichRep.findSandwichByCode(code);
	}
	
	/**
	 * Method responsible to calculate the price of the sandwich
	 * based on its ingredients quantity and value
	 * @param sandwich
	 */
	public void calculatePrice(Sandwich sandwich) {
		
		sandwich.getIngredients().forEach(ingredient -> {
			sandwich.setPrice(ingredient.getIngredientType().getPrice() * ingredient.getQuantity());
		});
	}
	
	/**
	 * This method creates the sandwiches menu
	 */
	private void createMenu() {
		sandwichRep.insertSandwich(new XBacon());
		sandwichRep.insertSandwich(new XBurger());
		sandwichRep.insertSandwich(new XEgg());
		sandwichRep.insertSandwich(new XEggBacon());
	}
}

