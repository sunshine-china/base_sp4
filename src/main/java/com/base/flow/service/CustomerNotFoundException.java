package com.base.flow.service;

import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Component
public class CustomerNotFoundException extends Exception {
  public CustomerNotFoundException() {}
  
  public CustomerNotFoundException(String message) {
    super(message);
  }
}
