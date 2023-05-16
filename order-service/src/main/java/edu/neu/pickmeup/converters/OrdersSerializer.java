package edu.neu.pickmeup.converters;

import edu.neu.pickmeup.model.Orders;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OrdersSerializer implements Serializer<Orders> {

	private final ObjectMapper mapper = new ObjectMapper();

	@Override
	public byte[] serialize(String topic, Orders data) {
		try {
			return mapper.writeValueAsBytes(data);
		} catch (JsonProcessingException e) {
			throw new SerializationException("Error when serializing Orders to byte[]");
		}
	}

}
