package com.mediBuddy.medicos.controllers.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class health {
    @GetMapping
    public String healthCheck(){
        System.out.println("System Is Live");
        return "System Is Live";
    }
}
