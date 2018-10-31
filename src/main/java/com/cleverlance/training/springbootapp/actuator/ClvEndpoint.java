package com.cleverlance.training.springbootapp.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Endpoint(id = "clv")
@Component
public class ClvEndpoint {

    @ReadOperation
    public String getValue() {
        return "move to Slatina";
    }

}
