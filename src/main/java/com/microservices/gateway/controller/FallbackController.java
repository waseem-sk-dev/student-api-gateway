package com.microservices.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

	@GetMapping("/students")
	public String studentFallback() {
		return "Student Service is temporarily unavailable.Pleasse try again later.";
	}

	@GetMapping("/courses")
	public String courseFallback() {
		return "Course Service is temporarily unavailable.Please try again later.";
	}
}
