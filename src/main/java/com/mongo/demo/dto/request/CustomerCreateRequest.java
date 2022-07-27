package com.mongo.demo.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CustomerCreateRequest {

    @NotBlank(message = "name field is empty")
    private String name;
    @NotBlank(message = "surname field is empty")
    private String surname;
}
