package edu.neu.pickmeup.controller;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.neu.pickmeup.model.Orders;
import edu.neu.pickmeup.service.ProducerService;

@RestController
@RequestMapping("/orders")
public class OrdersController {

	@Autowired
	private ProducerService<String, Orders> producer;

	@PostMapping
	public String processOrder(@RequestBody Orders order) {

		// send to kafka
		producer.send(order);

		return "PROCESSING";
	}
	
}
