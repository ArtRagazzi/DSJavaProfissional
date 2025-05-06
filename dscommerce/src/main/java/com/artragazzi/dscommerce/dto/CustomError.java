package com.artragazzi.dscommerce.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@AllArgsConstructor
@Getter

public class CustomError {
    private Instant timestamp;
    private Integer status;
    private String description;
    private String path;
}
