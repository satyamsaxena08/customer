package com.customer.controller;

import com.customer.payloads.CustomerDto;
import com.customer.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomers(@RequestBody CustomerDto customerDto){
        CustomerDto dto = customerService.createCustomers(customerDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }


}
