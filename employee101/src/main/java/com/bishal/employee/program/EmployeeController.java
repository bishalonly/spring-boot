package com.bishal.employee.program;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService es;
	

	@RequestMapping("/employee")
	public List<Employee> getAllEmployees() {
		
		return es.getAllEmployees();
	}
	
	@RequestMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable int id){
		return es.getEmployee(id);
	}

	//@RequestMapping(method=RequestMapping.POST, value="employee")
	@PostMapping
	public void addEmployee(Employee emp) {
		es.addEmployee(emp); 
	}
	
	
	@PutMapping
	public void updateEmployee(int id, Employee employee) {
		es.updateEmployee(id, employee);
	}
	
	
	@DeleteMapping
	public void deleteEmployee(int id) {
		es.deleteEmployee(id);
	}
	
}