package com.ibm.customer.message.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class CustomerMessageConsumerKafka implements CustomerMessageConsumer {
	
	private final Logger logger = LoggerFactory.getLogger(CustomerMessageConsumerKafka.class);

	@Value("${kafka.topic.name:added-order-pajemd}")
	private String topicName;

	@Override
	@KafkaListener(topics = "added-order-pajemd", groupId = "Library")
	public void consumeMessage(String addedOrderMsg) {
		logger.info("received order {}", addedOrderMsg);
	}

}
