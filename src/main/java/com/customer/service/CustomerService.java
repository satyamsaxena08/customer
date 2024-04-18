package com.customer.service;

import com.customer.payloads.CustomerDto;

public interface CustomerService {
    CustomerDto createCustomers(CustomerDto customerDto);

    CustomerDto getById(long id);
}
