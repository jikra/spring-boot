package com.cleverlance.training.springbootapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.cleverlance.training.springbootapp.controller",
        "com.cleverlance.training.springbootapp.property"})
public class WebAppConfig {
}
