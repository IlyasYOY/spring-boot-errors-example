package com.example.demo.configuration.properties.converter;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class IntegerToHttpStatusConverter implements Converter<Integer, HttpStatus> {
    @Override
    public HttpStatus convert(Integer source) {
        return HttpStatus.resolve(source);
    }
}
