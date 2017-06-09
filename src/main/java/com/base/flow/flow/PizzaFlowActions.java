package com.base.flow.flow;

import static com.base.flow.domain.PaymentType.CREDIT_CARD;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.base.flow.domain.CashOrCheckPayment;
import com.base.flow.domain.CreditCardPayment;
import com.base.flow.domain.Customer;
import com.base.flow.domain.Order;
import com.base.flow.domain.Payment;
import com.base.flow.domain.PaymentDetails;
import com.base.flow.service.CustomerNotFoundException;
import com.base.flow.service.CustomerService;

@Component
public class PizzaFlowActions {
	private static final Logger LOGGER = LogManager.getLogger(PizzaFlowActions.class);

	public Customer lookupCustomer(String phoneNumber) throws CustomerNotFoundException {
		Customer customer = customerService.lookupCustomer(phoneNumber);
		if (customer != null) {
			return customer;
		} else {
			throw new CustomerNotFoundException();
		}
	}

	public void addCustomer(Customer customer) {
		LOGGER.warn("TODO: Flesh out the addCustomer() method.");
	}

	public Payment verifyPayment(PaymentDetails paymentDetails) {
		Payment payment = null;
		if (paymentDetails.getPaymentType() == CREDIT_CARD) {
			payment = new CreditCardPayment();
		} else {
			payment = new CashOrCheckPayment();
		}

		return payment;
	}

	public void saveOrder(Order order) {
		LOGGER.warn("TODO: Flesh out the saveOrder() method.");
	}

	public boolean checkDeliveryArea(String zipCode) {
		LOGGER.warn("TODO: Flesh out the checkDeliveryArea() method.");
		return "75075".equals(zipCode);
	}

	@Autowired
	CustomerService customerService;
}
