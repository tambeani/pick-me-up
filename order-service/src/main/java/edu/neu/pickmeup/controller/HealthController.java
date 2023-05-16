package edu.neu.pickmeup.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HealthController {

	@GetMapping("/health")
	public String health() {
		return "Came from order-service - OK";
	}
}
