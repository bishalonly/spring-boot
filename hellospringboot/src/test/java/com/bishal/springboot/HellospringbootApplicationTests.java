package com.bishal.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bishal.springboot.entities.Student;
import com.bishal.springboot.repos.StudentRepository;
import com.bishal.springboot.services.PaymentService;
import com.bishal.springboot.services.PaymentServiceImpl;

@SpringBootTest
class HellospringbootApplicationTests {
	
	@Autowired
	PaymentServiceImpl service;

	@Autowired
	StudentRepository repo;
	
	@Test
	void testDependencyInjection() {
		assertNotNull(service.getDao(), "it is not bull, Bishal is really harding guy.");
	}
	
	@Test
	void testSaveStudent() {
		Student s = new Student();
		s.setId(101l);
		s.setName("bishal pradhan");
		s.setTestScore(99);
		repo.save(s);
		
		Student savedStudent = repo.findById(101l).get();
		
		System.out.println("s : " + s + "\n" +
				"savedStudent : " + repo.findById(101l));
		
		assertNotNull(savedStudent);
		//assertEquals(s, savedStudent);
	
	}

}
