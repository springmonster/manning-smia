package com.example.licensingservicevault.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class SharedConfig {

    @Value("${baz}")
    private String baz;

    @Value("${foo}")
    private String foo;

    @Value("${spring.user.name}")
    private String username;

}