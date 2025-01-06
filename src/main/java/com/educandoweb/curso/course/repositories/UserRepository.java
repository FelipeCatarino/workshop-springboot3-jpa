package com.educandoweb.curso.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.curso.course.entities.User;



public interface UserRepository extends JpaRepository<User, Long>{	
	
}
