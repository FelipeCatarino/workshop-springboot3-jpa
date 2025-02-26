package com.educandoweb.curso.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.course.entities.Order;
import com.educandoweb.curso.course.repositories.OrderRepository;

//camada responsável por acessar o banco de dados

@Service
public class OrderService {

	@Autowired  //para fazer a injeção de dependencia
	private OrderRepository repository;
	
	
	public List<Order> findAll(){
		
		return repository.findAll();
		
	}
	
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		
		return obj.get();
	}
}
