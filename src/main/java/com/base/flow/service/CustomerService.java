package com.base.flow.service;

import com.base.flow.domain.Customer;

public interface CustomerService {
	Customer lookupCustomer(String phoneNumber) throws CustomerNotFoundException;
}