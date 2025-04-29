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

import com.senac.pizzademo.model.Pedido;
import com.senac.pizzademo.repository.PedidosRepository;

@RestController
@RequestMapping("/pedidos")

public class PedidoController {

    @Autowired private PedidosRepository repository;

    @GetMapping
    public List<Pedido> listarPizzas() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPedidoPorId(@PathVariable Long id) {
        Optional<Pedido> pedido = repository.findById(id);

        if (pedido.isPresent())
            return ResponseEntity.ok(pedido.get());
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<Pedido> adicionarPedido(@RequestBody Pedido pedido) {
        Pedido pedidoSalvo = repository.save(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> atualizarPedido(@PathVariable Long id, @RequestBody Pedido pedido) {
        Optional<Pedido> pedidoExistente = repository.findById(id);
        if (pedidoExistente.isPresent()) {
            pedido.setId(id);
            Pedido pedidoAtualizado = repository.save(pedido);
            return ResponseEntity.ok(pedidoAtualizado);
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id) {
        Optional<Pedido> pedidoExistente = repository.findById(id);
        if (pedidoExistente.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
