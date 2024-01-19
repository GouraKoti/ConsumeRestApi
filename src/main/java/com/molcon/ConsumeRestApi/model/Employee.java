package com.molcon.ConsumeRestApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Employee {

    private String tokenId;

    private String userName;

    private String employeeNumber;

    private String email;

    private Integer expiresIn;

    private String expiration;
}
