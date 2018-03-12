package com.example.actuatordemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@Value("${message}")
	private String message;
	@Value("${description}")
	private String description;
	
	@GetMapping("/welcome")
	public String sayWelcome() {
		return this.message;
	}
	
	@GetMapping("/description")
	public String getDescription() {
		return this.description;
	}
	
}
