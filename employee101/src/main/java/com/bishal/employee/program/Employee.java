package com.bishal.employee.program;


public class Employee implements Comparable<Employee> {

	int id;
	String name;
	int exp;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String name, int exp) {
		super();
		this.id = id;
		this.name = name;
		this.exp = exp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	@Override
	public int compareTo(Employee emp) {
		return this.getExp() - emp.getExp();
	}

}