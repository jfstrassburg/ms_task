package com.api_java.ms_task.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api_java.ms_task.service.SingletonService;

@RestController
public class SingletonController {

    @Autowired
    private SingletonService singletonService;

    @GetMapping("/singleton")
    public String getSingletonMessage() {
        return singletonService.getMessage();
    }
}