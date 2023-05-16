package edu.neu.pickmeup.service;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Service;

@Service
public class ProducerService<K, V> {

	@Autowired
	private ProducerFactory<K, V> producerFactory;

	public void send(V v) {
		try (Producer<K, V> producer = producerFactory.createProducer()) {
			producer.send(new ProducerRecord<>("test", v));
		}
	}
}
