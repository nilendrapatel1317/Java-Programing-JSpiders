package com.sping.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@GetMapping("/home")
	public String openHome() {
		return "Hello, Welcome to Spring Boot";
	}
}
