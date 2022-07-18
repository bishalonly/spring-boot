package com.bishal.springdatajpa.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bishal.springdatajpa.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
/*
 * this is a layer which connects to our database
 * 
 * The interface must extends to JPARepository from springboot
 * 
 * Jpa repository takes entity class as the first parameter and 
 * primary key data type as the second
 * 
 * It has all the abstract method to perform CRUD operations
 * 
 * */	

}
