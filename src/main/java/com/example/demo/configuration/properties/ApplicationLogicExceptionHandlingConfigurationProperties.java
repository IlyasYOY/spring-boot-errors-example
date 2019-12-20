package com.example.demo.configuration.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Map;

@Getter
@Setter
@Validated
@ConfigurationProperties(prefix = "errors.handling")
public class ApplicationLogicExceptionHandlingConfigurationProperties {
    @NotNull
    private Map<@NotEmpty String, ErrorInfo> mappings;
    @NotEmpty
    private String defaultMessage = "Error occurred, please try again.";
    @NotNull
    private HttpStatus defaultErrorStatus = HttpStatus.INTERNAL_SERVER_ERROR;
}
