package com.brandonn.springboottemplate2.shared.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasicHttpResponseDto<T> {
    private String version;
    private int status;
    private String message;
    private T data;
}
