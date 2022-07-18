package com.bishal.springdatajpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bishal.springdatajpa.entities.Student;
import com.bishal.springdatajpa.repos.StudentRepository;

@RestController 
public class StudentRestController {
	
/*
 * Controller is a logic class from where we control the whole project.
 * It also have one more layer i.e. Service layer for presentation.
 * 
 * But here we are just using Controller, it is a stereotype annotation from spring
 * We are using RestController annotation so the compiler can specific know we are using Rest controls
 * 
 * Since we are not using any service layer we are directly injecting bean of Repository layer object 
 * to access the JPA methods 
 * 
 * 
 * 
 * */

	@Autowired
	private StudentRepository repo;
	
	@GetMapping("/student")
	public List<Student> getStudents() {
		return repo.findAll();
	}
	
	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable("id") long id) {
		return repo.findById(id).get();
	}
	
	@PostMapping("/student")
	public Student createStudent(@RequestBody Student student) {
		return repo.save(student);
	}
	
	@PutMapping("/student")
	public Student updateStudent(@RequestBody Student student) {
		return repo.save(student);
	}
	
	@DeleteMapping("/student/{id}")
	public void deleteStudent(@PathVariable("id") long id) {
		 repo.deleteById(id);
	}
	
	
	
}
