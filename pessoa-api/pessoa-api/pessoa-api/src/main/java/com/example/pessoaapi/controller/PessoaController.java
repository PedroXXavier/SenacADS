package com.example.pessoaapi.controller;

import com.example.pessoaapi.entity.Pessoa;
import com.example.pessoaapi.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pessoa")
@CrossOrigin("*")

public class PessoaController {

    private final PessoaRepository repository;

    @GetMapping
    public List<Pessoa> buscarTodasPessoas() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPessoaId(@PathVariable(name = "id") long id) {
        Optional<Pessoa> optionalDB = repository.findById(id);

        if (optionalDB.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(optionalDB.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void removerPessoaId(@PathVariable Long id) {
        if (repository.existsById(id))
            repository.deleteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa cadastrarNova(@RequestBody Pessoa novaPessoa) {
        novaPessoa.setId(null);
        return repository.save(novaPessoa);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void ativarStatus(@RequestBody Long id, boolean status) {
        repository.ativarStatus(id);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Pessoa> atualizarRegistro(@PathVariable Long id, @RequestBody Pessoa pessoaFront) {
        if (repository.existsById(id)) {
            pessoaFront.setId(id); Pessoa pessoaEditada = repository.save(pessoaFront);
            return new ResponseEntity<>(pessoaEditada, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
