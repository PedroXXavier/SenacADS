package com.senac.pizzademo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.pizzademo.model.User;
import com.senac.pizzademo.repository.UsersRepository;


@RestController
@RequestMapping("/users")

public class UserController {
        @Autowired private UsersRepository repository;

    @GetMapping
    public List<User> listarUsers() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> buscarUserPorId(@PathVariable Long id) {
        Optional<User> user = repository.findById(id);

        if (user.isPresent())
            return ResponseEntity.ok(user.get());
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<User> adicionarUser(@RequestBody User user) {
        User userSalvo = repository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> atualizarUser(@PathVariable Long id, @RequestBody User user) {
        Optional<User> userExistente = repository.findById(id);
        if (userExistente.isPresent()) {
            user.setId(id);
            User userAtualizado = repository.save(user);
            return ResponseEntity.ok(userAtualizado);
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUser(@PathVariable Long id) {
        Optional<User> userExistente = repository.findById(id);
        if (userExistente.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}