package com.cleverlance.training.springbootapp.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Component
@ConfigurationProperties(prefix = "app")
public class AppProperty {

    private String name;
    private String description;
    private String version;
    private String buildTime;

    @Autowired
    public AppProperty(BuildProperties buildProperties) {

        version = buildProperties.getVersion();
        buildTime = DateTimeFormatter.ofPattern("dd/MM/yyyy")
                .format(LocalDateTime.ofInstant(buildProperties.getTime(), ZoneId.systemDefault()));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public String getBuildTime() {
        return buildTime;
    }
}
