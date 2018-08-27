package com.sandwiches.api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sandwiches.api.entity.CustomSandwich;
import com.sandwiches.api.entity.Ingredient;
import com.sandwiches.api.entity.Sandwich;
import com.sandwiches.api.service.SandwichService;

@RestController
@RequestMapping("/sandwiches")
public class SandwichController {
	
	@Autowired
	SandwichService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Sandwich>> getMenu() {
		return ResponseEntity.status(HttpStatus.OK).body(service.getMenu());
	}

	@RequestMapping(value = "/{code}", method = RequestMethod.GET)
	public ResponseEntity<?> getBookById(@PathVariable("code") Long code) {
		Sandwich sandwich = service.getSandwichByCode(code);
		
		return ResponseEntity.status(HttpStatus.OK).body(sandwich);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insertSandwich(@RequestBody CustomSandwich custom) {
		
		Sandwich sandwich = service.save(custom);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
											 .path("/{id}")
											 .buildAndExpand(sandwich.getCode()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
}
