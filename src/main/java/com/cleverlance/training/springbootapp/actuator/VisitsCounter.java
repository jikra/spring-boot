package com.cleverlance.training.springbootapp.actuator;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VisitsCounter {

    private Counter visitsCounter;

    @Autowired
    public VisitsCounter(MeterRegistry meterRegistry) {

        this.visitsCounter = meterRegistry.counter("app-info-visits", Tags.empty());
    }


    public void increaseNumberOfVisits() {

        visitsCounter.increment();
    }
}
