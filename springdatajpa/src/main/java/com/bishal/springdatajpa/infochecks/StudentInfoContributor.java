package com.bishal.springdatajpa.infochecks;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import com.bishal.springdatajpa.repos.StudentRepository;

@Component
public class StudentInfoContributor implements InfoContributor {
	
	@Autowired
	StudentRepository sr;

	@Override
	public void contribute(Builder builder) {
		
		Map<String,Long> studentDetails = new HashMap<>();
		studentDetails.put("no of active students in database", sr.count());
		studentDetails.put("no of inactive students in database", sr.count());
		
		builder.withDetail("Student Info details", studentDetails);
	}

}
