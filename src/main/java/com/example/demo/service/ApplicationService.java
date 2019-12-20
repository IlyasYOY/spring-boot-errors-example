package com.example.demo.service;

import com.example.demo.exception.ApplicationLogicException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {
    public static final String ERROR_500 = "500";
    public static final String ERROR_400 = "400";
    public static final String RESPONSE = "Fine";

    private static final String HELLO_WORLD_400_CODE = "HELLO_WORLD_400";
    private static final String HELLO_WORLD_500_CODE = "HELLO_WORLD_500";

    public String processParam(String error) {
        switch (error) {
            case ERROR_400:
                throw new ApplicationLogicException(HELLO_WORLD_400_CODE);
            case ERROR_500:
                throw new ApplicationLogicException(HELLO_WORLD_500_CODE);
            default:
                return RESPONSE;
        }
    }
}
