// Pacote onde essa classe está localizada
package com.educandoweb.curso.course.resources;

//responsvel por se comunicar com camada de serviço

import java.util.List;

// Importação das anotações e classes necessárias do Spring Framework
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Importação das classes do projeto
import com.educandoweb.curso.course.entities.User;
import com.educandoweb.curso.course.services.UserService;

// Indica que essa classe é um controlador REST, ou seja, expõe endpoints para serem acessados via HTTP
@RestController
// Define a URL base para os endpoints dessa classe. Todos os endpoints dentro dessa classe começarão com "/users"
@RequestMapping(value = "/users")
public class UserResource {

    // Injeta automaticamente a instância de UserService, que será usada para acessar os dados dos usuários
    @Autowired
    private UserService service;

    // Define um endpoint GET para listar todos os usuários
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll();
        // Retorna a lista de usuários com o status HTTP 200 (OK)
        return ResponseEntity.ok().body(list);
    }

    // Define um endpoint GET para buscar um usuário específico pelo ID
    @GetMapping(value = "/{id}") // O {id} representa um parâmetro dinâmico na URL
    public ResponseEntity<User> findById(@PathVariable Long id) {
        // Chama o serviço para obter o usuário pelo ID
        User obj = service.findById(id);
        // Retorna o usuário encontrado com status HTTP 200 (OK)
        return ResponseEntity.ok(obj);
    }
}
