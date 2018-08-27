package com.sandwiches.api.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandwiches.api.entity.CustomSandwich;
import com.sandwiches.api.entity.Ingredient;
import com.sandwiches.api.entity.Sandwich;
import com.sandwiches.api.entity.XBacon;
import com.sandwiches.api.entity.XBurger;
import com.sandwiches.api.entity.XEgg;
import com.sandwiches.api.entity.XEggBacon;
import com.sandwiches.api.entity.enums.IngredientType;
import com.sandwiches.api.repository.SandwichRepository;

@Service
public class SandwichService {
	
	@Autowired
	SandwichRepository sandwichRep;
	
	public List<Sandwich> getMenu() {
		createMenu();
		List<Sandwich> sandwiches = new ArrayList<>(sandwichRep.getAllSandwiches());
		
		sandwiches.forEach(s -> calculatePrice(s));
		
		return sandwiches;
	}
	
	public Sandwich getSandwichByCode(Long code) {
		return sandwichRep.findSandwichByCode(code);
	}
	
	public Sandwich save(Sandwich sandwich) {
		calculatePrice(sandwich);
		
		this.sandwichRep.insertSandwich(sandwich);
		
		return sandwich;
	}
	
	/**
	 * Method responsible to calculate the price of the sandwich
	 * based on its ingredients quantity and value
	 * @param sandwich
	 */
	public void calculatePrice(Sandwich sandwich) {
		sandwich.getIngredients().forEach(i -> {
			sandwich.setPrice(i.getIngredientType().getValue() * i.getQuantity());
		}); 
		
		if (sandwich instanceof CustomSandwich) {
			calculatePromotion(sandwich);
		}
	}
	
	/**
	 * Calculates the promotion
	 * @param sandwich
	 */
	public void calculatePromotion(Sandwich sandwich) {
		boolean alface = false;
		boolean bacon = false;
		
		for (Ingredient i : sandwich.getIngredients()) {
			if (i.getIngredientType().equals(IngredientType.ALFACE)) {
				alface = true;
			} else if (i.getIngredientType().equals(IngredientType.BACON)) {
				bacon = true;
			}
		}
		
		if (alface && !bacon) {
			BigDecimal discount = new BigDecimal((sandwich.getPrice() * 10.0) / 100).setScale(2, 2);
			BigDecimal result = BigDecimal.valueOf(sandwich.getPrice()).subtract(discount).setScale(2, 2);
			sandwich.setPrice(result.doubleValue());
		}
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

