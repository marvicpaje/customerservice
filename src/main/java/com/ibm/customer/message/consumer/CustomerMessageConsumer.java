package com.ibm.customer.message.consumer;

public interface CustomerMessageConsumer {

	public void consumeMessage(String addedOrderMsg);
}
