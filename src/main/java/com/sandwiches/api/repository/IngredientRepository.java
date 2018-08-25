package com.sandwiches.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sandwiches.api.entity.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

}
