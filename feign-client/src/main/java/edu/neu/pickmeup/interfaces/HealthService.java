package edu.neu.pickmeup.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("order-service")
public interface HealthService {

	@GetMapping("/health")
	String health();

}
