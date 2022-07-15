package com.example.licensingservicevault.controller;

import com.example.licensingservicevault.config.ServiceConfig;
import com.example.licensingservicevault.config.SharedConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private ServiceConfig serviceConfig;

    @Autowired
    private SharedConfig sharedConfig;

    @GetMapping("/property")
    public String getProperty() {
        return serviceConfig.getProperty();
    }

    @GetMapping("/shared")
    public String getShared() {
        return sharedConfig.toString();
    }
}
