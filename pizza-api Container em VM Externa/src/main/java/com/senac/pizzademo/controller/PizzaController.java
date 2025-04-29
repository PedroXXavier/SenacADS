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

import com.senac.pizzademo.model.Pizza;
import com.senac.pizzademo.repository.PizzasRepository;


@RestController
@RequestMapping("/pizzas")

public class PizzaController {
    @Autowired private PizzasRepository repository;

    @GetMapping
    public List<Pizza> listarPizzas() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pizza> buscarPizzaPorId(@PathVariable Long id) {
        Optional<Pizza> pizza = repository.findById(id);

        if (pizza.isPresent())
            return ResponseEntity.ok(pizza.get());
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<Pizza> adicionarPizza(@RequestBody Pizza pizza) {
        Pizza pizzaSalvo = repository.save(pizza);
        return ResponseEntity.status(HttpStatus.CREATED).body(pizzaSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pizza> atualizarPizza(@PathVariable Long id, @RequestBody Pizza pizza) {
        Optional<Pizza> pizzaExistente = repository.findById(id);
        if (pizzaExistente.isPresent()) {
            pizza.setId(id);
            Pizza pizzaAtualizado = repository.save(pizza);
            return ResponseEntity.ok(pizzaAtualizado);
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPizza(@PathVariable Long id) {
        Optional<Pizza> pizzaExistente = repository.findById(id);
        if (pizzaExistente.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
