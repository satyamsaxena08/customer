package com.customer.service.impl;

import com.customer.entity.Customer;
import com.customer.payloads.CustomerDto;
import com.customer.repository.CustomerRepository;
import com.customer.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto createCustomers(CustomerDto customerDto) {
       //Convert customer entity to customerDto
        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobile(customerDto.getMobile());

        //save customer entity
        Customer saveCustomer = customerRepository.save(customer);

        //convert savedCustomer to CustomerDto

        CustomerDto dto = new CustomerDto();
        dto.setFirstName(saveCustomer.getFirstName());
        dto.setLastName(saveCustomer.getLastName());
        dto.setEmail(saveCustomer.getEmail());
        dto.setMobile(saveCustomer.getMobile());
        return dto;
    }
}
