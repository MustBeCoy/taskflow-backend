package com.taskflow.taskflow.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testcontroller {
    @GetMapping("/health")
    public String health(){
        return "Taskflow is running";
    }
}
