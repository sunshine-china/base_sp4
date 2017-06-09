package com.base.flow.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.base.flow.domain.Order;

@Service
public class OrderServiceImpl {
	private static final Logger LOGGER = LogManager.getLogger(OrderServiceImpl.class);

	public OrderServiceImpl() {
	}

	public void saveOrder(Order order) {
		LOGGER.debug("SAVING ORDER:  ");
		LOGGER.debug("   Customer:  " + order.getCustomer().getName());
		LOGGER.debug("   # of Pizzas:  " + order.getPizzas().size());
		LOGGER.debug("   Payment:  " + order.getPayment());
	}
}
