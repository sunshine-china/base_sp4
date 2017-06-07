package com.base.flow.service;

import com.base.flow.domain.Order;

public interface PricingEngine {
	public float calculateOrderTotal(Order order);
}
