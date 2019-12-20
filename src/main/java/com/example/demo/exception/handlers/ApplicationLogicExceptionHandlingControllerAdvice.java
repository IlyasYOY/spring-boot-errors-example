package com.example.demo.exception.handlers;

import com.example.demo.configuration.properties.ApplicationLogicExceptionHandlingConfigurationProperties;
import com.example.demo.configuration.properties.ErrorInfo;
import com.example.demo.exception.ApplicationLogicException;
import com.example.demo.exception.handlers.dto.ErrorType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.UUID;

@ControllerAdvice
@RequiredArgsConstructor
public class ApplicationLogicExceptionHandlingControllerAdvice extends ResponseEntityExceptionHandler {
    private final ApplicationLogicExceptionHandlingConfigurationProperties configurationProperties;

    @ExceptionHandler(ApplicationLogicException.class)
    public ResponseEntity<ErrorType> handleApplicationLogicException(ApplicationLogicException ex) {
        String errorId = ex.getErrorId();

        ErrorInfo defaultErrorInfo = new ErrorInfo()
                .setMessage(configurationProperties.getDefaultMessage())
                .setStatus(configurationProperties.getDefaultErrorStatus());

        ErrorInfo errorInfo = configurationProperties.getMappings().getOrDefault(errorId, defaultErrorInfo);

        ErrorType errorType = ErrorType.builder()
                .errorId(UUID.randomUUID().toString())
                .message(errorInfo.getMessage())
                .build();

        return ResponseEntity
                .status(errorInfo.getStatus())
                .body(errorType);
    }

}
