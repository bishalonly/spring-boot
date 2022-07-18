package com.bishal.thymeleaf.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bishal.thymeleaf.model.Student;

@Controller
@RequestMapping("/home")
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@RequestMapping("/tello")
	public String bello() {
		return "bello"; //this needs to be the HTML file name, requestMapping annotation is just for the URL/URI
	}
	
	@RequestMapping("/getData")
	public ModelAndView getData() {
		ModelAndView mav = new ModelAndView("data");
		mav.addObject("Quote", "Arise and Work till the goal is reached");
		return mav;
	}
	
	@RequestMapping("/getStudent")
	public ModelAndView getStudent() {
		ModelAndView mav = new ModelAndView("student");
		Student student = new Student();
		student.setName("Bishal");
		student.setScore(100);
		mav.addObject("studentInfo", student);
		return mav;
	}

	
	@RequestMapping("/getStudents")
	public ModelAndView getStudents() {
		ModelAndView mav = new ModelAndView("studentList");
		Student student = new Student();
		student.setName("Bishal");
		student.setScore(100);
		
		Student student2 = new Student();
		student2.setName("Aman");
		student2.setScore(99);
		
		List<Student> students = Arrays.asList(student,student2);
		
		mav.addObject("studentsInfo", students);
		return mav;
	}
}
