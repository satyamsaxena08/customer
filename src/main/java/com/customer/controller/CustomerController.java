package com.customer.controller;

import com.customer.payloads.CustomerDto;
import com.customer.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public ResponseEntity<CustomerDto> getCustomerByid(@RequestParam long id){
        CustomerDto dto = customerService.getById(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }


}
