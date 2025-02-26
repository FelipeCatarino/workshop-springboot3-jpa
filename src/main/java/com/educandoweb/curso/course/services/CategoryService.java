package com.educandoweb.curso.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.course.entities.Category;
import com.educandoweb.curso.course.repositories.CategoryRepository;

//camada responsável por acessar o banco de dados

@Service
public class CategoryService {

	@Autowired  //para fazer a injeção de dependencia
	private CategoryRepository repository;
	
	
	public List<Category> findAll(){
		
		return repository.findAll();
		
	}
	
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		
		return obj.get();
	}
}
