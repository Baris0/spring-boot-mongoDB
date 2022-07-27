package com.mongo.demo.controller;

import com.mongo.demo.dto.CustomerDto;
import com.mongo.demo.dto.request.CustomerCreateRequest;
import com.mongo.demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/get/all-customer")
    public ResponseEntity<List<CustomerDto>> getAll() {
        return new ResponseEntity<>(customerService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/add/customer")
    public ResponseEntity<CustomerDto> save(@Valid @RequestBody CustomerCreateRequest request) {
        return new ResponseEntity<>(customerService.save(request), HttpStatus.CREATED);
    }

    @GetMapping("/get/customer-name/{name}")
    public ResponseEntity<List<CustomerDto>> getCustomerByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(customerService.getCustomerByName(name), HttpStatus.OK);
    }

    @GetMapping("/get/customer-id/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("id") String id) {
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }
}
