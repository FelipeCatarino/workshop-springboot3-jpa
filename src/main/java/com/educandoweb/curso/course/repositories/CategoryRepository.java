package com.educandoweb.curso.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.curso.course.entities.Category;



public interface CategoryRepository extends JpaRepository<Category, Long>{	
	
}
