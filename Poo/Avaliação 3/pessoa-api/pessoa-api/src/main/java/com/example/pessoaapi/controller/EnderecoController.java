package com.example.pessoaapi.controller;

import com.example.pessoaapi.entity.Endereco;
import com.example.pessoaapi.entity.Pessoa;
import com.example.pessoaapi.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@RequestMapping("/enderecos")
@RequiredArgsConstructor

public class EnderecoController {
    private final EnderecoRepository repository;

    //Adicionar novo endereco
    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco salvarNovoEndereco(@RequestBody Endereco novoEndereco){
        novoEndereco.setId(new Random().nextLong(99));
        return repository.save(novoEndereco);
    }

    //Remover endereco por id
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerEndereco(@PathVariable Long id){
        if(repository.existsById(id))
            repository.deleteById(id);
    }

    //Atualizar endereco por id
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void atualizarDadosEndereco(@PathVariable Long id, @RequestBody Endereco endereco){
        if(repository.existsById(id)){
            endereco.setId(id); repository.save(endereco);
        }
    }

    @GetMapping
    public List<Endereco> buscarTodosEnderecos(){
        return repository.findAll();
    }
}
