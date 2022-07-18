package com.bishal.springboot.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bishal.springboot.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	//public interface StudentRepository extends JpaRepository<T, ID> 
	// T is for Entity, so give the name of the Entity class here
	// ID is the type of primary key, so give the type of the primary key variable
}
