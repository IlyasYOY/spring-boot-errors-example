package com.example.demo.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
@RequiredArgsConstructor
public class ApplicationLogicException extends RuntimeException {
    private final String errorId;

    public ApplicationLogicException(String message, String errorId) {
        super(message);
        this.errorId = errorId;
    }

    public ApplicationLogicException(String message, String errorId, Throwable cause) {
        super(message, cause);
        this.errorId = errorId;
    }
}
