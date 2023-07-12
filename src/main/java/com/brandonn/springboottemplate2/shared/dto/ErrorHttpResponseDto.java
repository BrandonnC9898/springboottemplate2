package com.brandonn.springboottemplate2.shared.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorHttpResponseDto {
    private int errorCode;
    private String description;
}
