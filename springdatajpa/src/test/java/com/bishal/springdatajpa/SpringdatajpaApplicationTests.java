package com.bishal.springdatajpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.bishal.springdatajpa.entities.Product;
import com.bishal.springdatajpa.entities.Student;

import com.bishal.springdatajpa.repos.StudentRepository;

@SpringBootTest
class SpringdatajpaApplicationTests {
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Value("${productrestapi.services.url}")
	private String baseURL ;
	
	
	private String url = "http://localhost:8080/products/1"; 
	
	@Test
	public void testGetProduct() {
		System.out.println("base url: " + baseURL);
		//RestTemplate is used to create our own Rest client.
		/*
		 * Earlier in the Rest Controller we just created Rest Apis
		 * to hit those apis we need a rest client
		 * that time we used postman as our rest client
		 * 
		 * But now with the help of RestTemplate we are creating our own Rest Client
		 * and testing it in the project itself 
		 * 
		 * */
		
		
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(baseURL +"/1", Product.class);
		
		assertNotNull(product);
		assertEquals("ven-huesen", product.getName(), "Correct they are equals. Nice work");
	}
	
	@Test
	public void testCreateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = new Product();
		product.setDescription("foldable phone");
		product.setName("Samsung Fold 2");
		product.setPrice(399);
		
		Product newProduct = restTemplate.postForObject(baseURL, product, Product.class);
		
		assertNotNull(newProduct);
		assertNotNull(newProduct.getId());
		assertEquals("Samsung Fold 2", newProduct.getName());		
	}
	
	@Test
	public void testUpdateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(url, Product.class);
		product.setPrice(475);
		
		restTemplate.put("http://localhost:8080/products", product);
	}
	
	
	
	

	@Test
	@BeforeEach
	@Disabled
	void testCreateStudent() {
		//create
		Student student = new Student();
		student.setId(1l);
		student.setName("bishal pradhan");
		student.setTestscore(100);
		studentRepo.save(student);
	
		Student savedStudent = studentRepo.findById(1l).get();
		
		assertNotNull(savedStudent);
		
		//assertEquals(student, savedStudent);
	}
	
	@Test
	@BeforeEach
	@Disabled
	void  testReadStudent() {
		System.out.println("bishal student list : " + studentRepo.findAll());
		Student s = studentRepo.findById(1l).get();
		System.out.println("name: " + s.getName() + "id: " + s.getId() + "score: " + s.getTestscore());
		assertNotNull(studentRepo.findAll());
	}
	
	@Test
	@AfterEach
	@Disabled
	void testUpdateScoreStudent() {
		
		Student s = studentRepo.findById(1l).get();
		s.setTestscore(99);
		studentRepo.save(s);
		assertEquals(s.getTestscore(), 99, "Test score is updated and validated");
	}
	
	@Test
	@Disabled
	void testDeleteStudent() {
		 studentRepo.deleteById(1l);
		 System.out.println("print log " +studentRepo.findById(1l).get());
		 //assertNull(studentRepo.findById(1l).get());
		 assertFalse(studentRepo.findById(1l).isPresent());
		 System.out.println("print log " +studentRepo.findById(1l).get());
	}
	
	

}
