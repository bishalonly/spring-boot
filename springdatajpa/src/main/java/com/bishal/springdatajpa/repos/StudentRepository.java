package com.bishal.springdatajpa.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bishal.springdatajpa.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
