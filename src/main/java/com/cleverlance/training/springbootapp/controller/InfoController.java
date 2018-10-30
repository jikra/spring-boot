package com.cleverlance.training.springbootapp.controller;

import com.cleverlance.training.springbootapp.property.AppProperty;
import com.cleverlance.training.springbootapp.property.DbProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class InfoController {

    private final AppProperty appProperty;
    private final DbProperty dbProperty;
    @Value("${environment}")
    private String environment;

    @Autowired
    public InfoController(AppProperty appProperty, DbProperty dbProperty) {
        this.appProperty = appProperty;
        this.dbProperty = dbProperty;
    }

    @GetMapping("/info")
    public String getInfo(Model model) {

        model.addAttribute("appName", appProperty.getName());
        model.addAttribute("appVersion", appProperty.getVersion());
        model.addAttribute("appBuildTime", appProperty.getBuildTime());

        model.addAttribute("environment", environment);

        model.addAttribute("dbUrl", dbProperty.getUrl());
        return "info/info";
    }
}