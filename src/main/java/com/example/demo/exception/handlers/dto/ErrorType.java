package com.example.demo.exception.handlers.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ErrorType {
    String errorId;
    String message;
}
