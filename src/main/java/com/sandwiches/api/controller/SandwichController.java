package com.sandwiches.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sandwiches.api.entity.Sandwich;
import com.sandwiches.api.service.SandwichService;

@RestController
@RequestMapping("/menu")
public class SandwichController {
	
	@Autowired
	SandwichService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Sandwich>> getMenu() {
		return ResponseEntity.status(HttpStatus.OK).body(service.getMenu());
	}


}
