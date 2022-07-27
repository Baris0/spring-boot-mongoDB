package com.mongo.demo.dto.converter;

import com.mongo.demo.dto.CustomerDto;
import com.mongo.demo.model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerDtoConverter {

    public CustomerDto convert(Customer customer) {
        return new CustomerDto(customer.getName(),
                customer.getSurname());
    }

    public List<CustomerDto> convert(List<Customer> customers) {
        return customers.stream().map(this::convert).collect(Collectors.toList());
    }

}
