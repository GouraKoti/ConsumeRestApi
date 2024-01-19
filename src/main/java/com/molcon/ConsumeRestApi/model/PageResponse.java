package com.molcon.ConsumeRestApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PageResponse {
    private Integer totalElements;
    private Integer totalPages;
    private List<Employee> content;
}
