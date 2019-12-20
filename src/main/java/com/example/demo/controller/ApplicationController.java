package com.example.demo.controller;

import com.example.demo.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static com.example.demo.service.ApplicationService.RESPONSE;

@RestController
@RequiredArgsConstructor
public class ApplicationController {
    public static final String ERROR_PARAM_NAME = "error";

    private final ApplicationService applicationService;

    @GetMapping
    public ResponseEntity<String> get(
            @RequestParam(value = ERROR_PARAM_NAME) Optional<String> errorOptional
    ) {
        return errorOptional
                .map(applicationService::processParam)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.ok(RESPONSE));
    }
}
