package com.api_java.ms_task.util;

public class ConfigManager {

    // Instância única da classe
    private static ConfigManager instance;

    // Propriedades de configuração
    private String appName = "ms_task";
    private String version = "1.0";

    // Construtor privado para evitar instâncias externas
    private ConfigManager() {}

    // Método público para obter a instância única
    public static synchronized ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    // Métodos de acesso às configurações
    public String getAppName() {
        return appName;
    }

    public String getVersion() {
        return version;
    }
}