package com.educandoweb.curso.course.config;

//Classe auxiliar para realizar algumas configurações

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.curso.course.entities.User;
import com.educandoweb.curso.course.repositories.UserRepository;

@Configuration
@Profile("test")					//commandLineRunner interface com método que é executado assim que a aplicação inicia
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@email.com", "977777777", "123456");
		User u2 = new User(null, "Alex Green", "maria@email.com", "930307878", "654321");
		User u3 = new User(null, "Felipe Catarino", "felipe@email.com", "940028922", "123654");
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
	
	}
	
	
	
}
