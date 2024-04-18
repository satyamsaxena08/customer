package com.customer.payloads;

import lombok.Data;

@Data
public class CustomerDto {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private long mobile;

}
