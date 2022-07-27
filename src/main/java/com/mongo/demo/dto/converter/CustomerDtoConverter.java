package com.mongo.demo.dto.converter;

import com.mongo.demo.dto.CustomerDto;
import com.mongo.demo.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoConverter {

    public CustomerDto convert(Customer customer) {
        return new CustomerDto(customer.getName(),
                customer.getSurname());
    }

}
