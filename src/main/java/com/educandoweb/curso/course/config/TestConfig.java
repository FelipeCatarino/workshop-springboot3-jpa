package com.educandoweb.curso.course.config;

import java.time.Instant;

//Classe auxiliar para realizar algumas configurações

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.curso.course.entities.Category;
import com.educandoweb.curso.course.entities.Order;
import com.educandoweb.curso.course.entities.User;
import com.educandoweb.curso.course.entities.enums.OrderStatus;
import com.educandoweb.curso.course.repositories.CategoryRepository;
import com.educandoweb.curso.course.repositories.OrderRepository;
import com.educandoweb.curso.course.repositories.UserRepository;

@Configuration
@Profile("test")					//commandLineRunner interface com método que é executado assim que a aplicação inicia
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers"); 

		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		User u1 = new User(null, "Maria Brown", "maria@email.com", "977777777", "123456");
		User u2 = new User(null, "Alex Green", "maria@email.com", "930307878", "654321");
		User u3 = new User(null, "Felipe Catarino", "felipe@email.com", "940028922", "123654");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID ,u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT ,u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT ,u1); 
		Order o4 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.SHIPPED ,u3); 
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3,o4));
		
		
	}
	
	
	
}
