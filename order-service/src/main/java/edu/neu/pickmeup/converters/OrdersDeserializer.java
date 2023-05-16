package edu.neu.pickmeup.converters;

import edu.neu.pickmeup.model.Orders;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OrdersDeserializer implements Deserializer<Orders> {

	private final ObjectMapper mapper = new ObjectMapper();

	@Override
	public Orders deserialize(String topic, byte[] data) {
		// TODO Auto-generated method stub
		try {
			return mapper.readValue(data, Orders.class);
		} catch (Exception e) {
			throw new SerializationException("Error when deserializing byte[] to Orders");
		}
	}

}
