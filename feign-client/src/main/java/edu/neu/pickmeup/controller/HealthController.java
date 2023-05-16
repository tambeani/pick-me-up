package edu.neu.pickmeup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.neu.pickmeup.interfaces.HealthService;

@RestController
public class HealthController {

	@Autowired
	private HealthService healthService;

	@GetMapping("/health")
	public String health() {
		return healthService.health();
	}
}
