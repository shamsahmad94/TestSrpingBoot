package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableTransactionManagement
public class ConfigManager {

    public static final String DATABASE_NAME = System.getProperty("DATABASE_NAME");
    public static final String DB_URL = System.getProperty("DB_URL");
    public static final String DB_USER = System.getProperty("DB_USER");
    public static final String DB_PASS = System.getProperty("DB_PASS");
    public static final String DB_CLASS_NAME = System.getProperty("DB_CLASS_NAME");
    public static final String SERVER_PORT = System.getProperty("SERVER_PORT");
    public static final String HIBERNATE_AUTO = System.getProperty("HIBERNATE_AUTO");
    public static final String AUTH_TOKEN = "oauth 6d9ca027b08bf17ec9e60027050475df85834644";
   

}