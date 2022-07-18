package com.bishal.springdatajpa.healthcheck;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicators implements HealthIndicator {
	
	// this class is needed to define or check different health links of actuators

	@Override
	public Health health() {
		boolean error = true;
		
		if(error)
			return Health.down().withDetail("need to have a doctors appointment", 123).build();
		
		return Health.up().build();
	}

}
