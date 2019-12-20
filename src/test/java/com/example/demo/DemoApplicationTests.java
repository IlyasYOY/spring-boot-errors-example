package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static com.example.demo.controller.ApplicationController.*;
import static com.example.demo.service.ApplicationService.*;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test 500")
    void test500() throws Exception {
        mockMvc.perform(get("/")
                .param(ERROR_PARAM_NAME, ERROR_500)
        ).andDo(print())
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.message", is("Hello,  World of 500's!")));
    }

    @Test
    @DisplayName("Test 400")
    void test400() throws Exception {
        mockMvc.perform(get("/")
                .param(ERROR_PARAM_NAME, ERROR_400)
        ).andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", is("Hello,  World of 400's!")));
    }

    @Test
    @DisplayName("Test ok")
    void testOk() throws Exception {
        mockMvc.perform(
                get("/")
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(RESPONSE));
    }

}
