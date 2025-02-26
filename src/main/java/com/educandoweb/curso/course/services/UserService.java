package com.educandoweb.curso.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.course.entities.User;
import com.educandoweb.curso.course.repositories.UserRepository;

//camada responsável por acessar o banco de dados

@Service
public class UserService {

	@Autowired  //para fazer a injeção de dependencia
	private UserRepository repository;
	
	
	public List<User> findAll(){
		
		return repository.findAll();
		
	}
	
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		
		return obj.get();
	}
}
