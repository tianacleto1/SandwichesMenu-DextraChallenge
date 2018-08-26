package com.sandwiches.api.repository;

import java.util.Collection;
import org.springframework.stereotype.Repository;
import com.sandwiches.api.entity.Sandwich;

@Repository
public class SandwichRepository {

	private final Database db;
	
	public SandwichRepository(Database db) {
		this.db = db;
	}
	
	public void insertSandwich(Sandwich sandwich) {
		db.getSandwiches().put(sandwich.getCode(), sandwich);
	}
	
	public Sandwich findSandwichByCode(Long code) {
		return this.db.getSandwiches().get(code);
	}
	
	public Collection<Sandwich> getAllSandwiches() {
		return db.getSandwiches().values();
	}
}
