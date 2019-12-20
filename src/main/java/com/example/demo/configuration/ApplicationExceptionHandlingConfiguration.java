package com.example.demo.configuration;

import com.example.demo.configuration.properties.ApplicationLogicExceptionHandlingConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(
        ApplicationLogicExceptionHandlingConfigurationProperties.class
)
public class ApplicationExceptionHandlingConfiguration {
}
