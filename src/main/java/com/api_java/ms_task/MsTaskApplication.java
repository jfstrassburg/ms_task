package com.api_java.ms_task;

import com.api_java.ms_task.util.ConfigManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MsTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsTaskApplication.class, args);

        // Usando o Singleton
        ConfigManager config = ConfigManager.getInstance();
        System.out.println("Aplicação: " + config.getAppName());
        System.out.println("Versão: " + config.getVersion());
    }
}
