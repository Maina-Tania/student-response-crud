package com.example.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntityResponse<T> {
    private T entity;
    private String message;
    private Integer statusCode;
}
