package com.cleverlance.training.springbootapp.controller;

import com.cleverlance.training.springbootapp.property.AppProperty;
import com.cleverlance.training.springbootapp.property.DbProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    private final AppProperty appProperty;
    private final DbProperty dbProperty;
    @Value("${environment}")
    private String environment;

    @Autowired
    public InfoController(AppProperty appProperty, DbProperty dbProperty) {
        this.appProperty = appProperty;
        this.dbProperty = dbProperty;
        System.out.println("foo");
    }

    @GetMapping("/info")
    public String getUsers() {

        return "app " + appProperty.getName() + ":" + appProperty.getVersion() + " was build: " + appProperty.getBuildTime() + "\n"
                + "Run in: [" + environment + "] environment.\n"
                + "Uses db on url:" + dbProperty.getUrl();
    }
}