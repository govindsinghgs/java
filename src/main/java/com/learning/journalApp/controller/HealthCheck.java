package com.learning.journalApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {
    @GetMapping("/Health")
    public String checkHealth(){
        return "Server Running Fine";
    }
}
