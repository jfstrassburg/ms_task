package com.api_java.ms_task.service;

import org.springframework.stereotype.Service;

@Service
public class SingletonService {

    public String getMessage() {
        return "Este é um serviço Singleton gerenciado pelo Spring!";
    }
}