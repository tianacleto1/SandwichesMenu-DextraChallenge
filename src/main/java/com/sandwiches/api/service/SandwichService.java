package com.sandwiches.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandwiches.api.entity.Ingredient;
import com.sandwiches.api.entity.Sandwich;
import com.sandwiches.api.entity.XBacon;
import com.sandwiches.api.entity.XBurger;
import com.sandwiches.api.entity.XEgg;
import com.sandwiches.api.entity.XEggBacon;
import com.sandwiches.api.entity.enums.IngredientType;
import com.sandwiches.api.repository.IngredientRepository;
import com.sandwiches.api.repository.SandwichRepository;

@Service
public class SandwichService {
	
	@Autowired
	IngredientRepository ingredientRep;
	
	@Autowired
	SandwichRepository sandwichRep;
	
	public List<Sandwich> getMenu() {
		createMenu();
		
		return this.sandwichRep.findAll();
	}
	
	/**
	 * This method creates the sandwiches menu
	 */
	private void createMenu() {
		ingredientRep.saveAndFlush(new Ingredient(10l, IngredientType.ALFACE, 1));
		ingredientRep.saveAndFlush(new Ingredient(11l, IngredientType.BACON, 1));
		ingredientRep.saveAndFlush(new Ingredient(12l, IngredientType.HAMBURGER, 1));
		ingredientRep.saveAndFlush(new Ingredient(13l, IngredientType.OVO, 1));
		ingredientRep.saveAndFlush(new Ingredient(14l, IngredientType.QUEIJO, 1));

		sandwichRep.saveAndFlush(new XBacon());
		sandwichRep.saveAndFlush(new XBurger());
		sandwichRep.saveAndFlush(new XEgg());
		sandwichRep.saveAndFlush(new XEggBacon());
	}
}

