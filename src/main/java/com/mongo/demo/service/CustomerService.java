package com.mongo.demo.service;

import com.mongo.demo.dto.CustomerDto;
import com.mongo.demo.dto.converter.CustomerDtoConverter;
import com.mongo.demo.dto.request.CustomerCreateRequest;
import com.mongo.demo.exception.CustomerNotFoundException;
import com.mongo.demo.model.Customer;
import com.mongo.demo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerDtoConverter customerDtoConverter;

    public List<CustomerDto> getAll() {
        final List<Customer> customers = customerRepository.findAll();
        return customerDtoConverter.convert(customers);
    }

    public CustomerDto save(CustomerCreateRequest request) {
        Customer customer = new Customer();
        customer.setId(UUID.randomUUID().toString());
        customer.setName(request.getName());
        customer.setSurname(request.getSurname());

        customerRepository.save(customer);
        return customerDtoConverter.convert(customer);
    }

    public List<CustomerDto> getCustomerByName(String name) {
        List<Customer> customers = customerRepository.findCustomerByName(name);
        return customerDtoConverter.convert(customers);

    }

    public CustomerDto getCustomerById(String id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.map(customerDtoConverter::convert).orElseThrow(()
                -> new CustomerNotFoundException("Customer not found, id: " + id));
    }

}
