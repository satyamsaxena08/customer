package com.customer.service.impl;

import com.customer.Exception.ResourceNotFoundException;
import com.customer.entity.Customer;
import com.customer.payloads.CustomerDto;
import com.customer.repository.CustomerRepository;
import com.customer.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
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

//    @Override
//    public CustomerDto getById(long id) {
//        Optional<Customer> findBy = customerRepository.findById(id);
//        Customer customer = findBy.get();
//        CustomerDto customerDto = new CustomerDto();
//        customerDto.setId(customer.getId());
//        customerDto.setFirstName(customer.getFirstName());
//        customerDto.setLastName(customer.getLastName());
//        customerDto.setEmail(customer.getEmail());
//        customerDto.setMobile(customer.getMobile());
//        return customerDto;
//    }
    @Override
    public CustomerDto getById(long id){
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("customer Not Found With id:- " + id)
        );
//       Now we have to convert Entity to Dto
//        CustomerDto dto = new CustomerDto();
//        dto.setId(customer.getId());
//        dto.setFirstName(customer.getFirstName());
//        dto.setLastName(customer.getLastName());
//        dto.setEmail(customer.getEmail());
//        dto.setMobile(customer.getMobile());

        return mapToDto(customer);
    }

//this will convert Entity obj to dtos
   CustomerDto mapToDto(Customer customer) {

        CustomerDto dto = new CustomerDto();
        dto.setId(customer.getId());
        dto.setFirstName(customer.getFirstName());
        dto.setLastName(customer.getLastName());
        dto.setEmail(customer.getEmail());
        dto.setMobile(customer.getMobile());

        return dto;

    }

    //THis will convert Dtos to Entity
    Customer mapToEntity(CustomerDto customerDto){

        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobile(customerDto.getMobile());

        return customer;
    }
}
