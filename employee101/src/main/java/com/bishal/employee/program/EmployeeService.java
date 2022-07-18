package com.bishal.employee.program;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;



@Service
public class EmployeeService {
	
	 List<Employee> emp = new ArrayList<>();
	
	public List<Employee> getAllEmployees() {
		 emp = Arrays.asList(
				new Employee(1,"bishal",2),
				new Employee(2,"Aman",1)
				);
		
		return emp;
	}


	public Employee getEmployee(int id) {
		for(int i=0; i<emp.size(); i++) {
			Employee e = emp.get(i);
			if(e.getId() == id)
				return e;
		}
		return null;
	}
	
	public Employee addEmployee(Employee employee) {
		emp.add(employee);
		return employee;
	}
	
	public List<Employee> deleteEmployee(int id) {
		for(int i=0; i<emp.size(); i++) {
			if(emp.get(i).getId() == id)
				emp.remove(i);
		}
		return emp;
	}
	
	public Employee updateEmployee(int id, Employee employee) {
		for(int i=0; i<emp.size(); i++) {
			if(emp.get(i).getId() == id) {
				emp.set(i, employee);
			}
		}
		return employee;
	}

}
