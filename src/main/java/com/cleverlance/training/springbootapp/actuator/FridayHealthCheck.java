package com.cleverlance.training.springbootapp.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class FridayHealthCheck implements HealthIndicator {

    @Override
    public Health health() {

        int dayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);

        return dayOfWeek == Calendar.FRIDAY ?
                Health.down().withDetail("is friday", 0).build() :
                Health.up().withDetail("nope", 1).build();
    }
}
