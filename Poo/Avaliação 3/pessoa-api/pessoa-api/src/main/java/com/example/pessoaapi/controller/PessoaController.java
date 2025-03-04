package com.example.pessoaapi.controller;

import com.example.pessoaapi.entity.Pessoa;
import com.example.pessoaapi.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/pessoas")
@RequiredArgsConstructor
public class PessoaController {
    private final PessoaRepository repository;

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa salvarNovaPessoa(@RequestBody Pessoa novaPessoa){
        return repository.save(novaPessoa);
    }

    //Remover pessoa por id
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPessoa(@PathVariable Long id){
        if(repository.existsById(id))
            repository.deleteById(id);
    }

    //Atualizar dados por id
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void atualizarDadosPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa){
        if(repository.existsById(id)){
            pessoa.setId(id); repository.save(pessoa);
        }
    }

    //Buscar pessoa por id
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Pessoa> buscarPessoaPorID(@PathVariable Long id){
        Optional<Pessoa> pessoaID = repository. findById(id);

        if(pessoaID.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(pessoaID.get(), HttpStatus.OK);
    }

    //Buscar todas as pessoas cadastradas
    @GetMapping
    public List<Pessoa> buscarTodasPessoas(){
        return repository.findAll();
    }
}
