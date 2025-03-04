package com.example.pessoaapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "db-pessoa")
@Entity
public class Pessoa {
    @Column @Id private Long id;

    @Column(nullable = false) private String nome;
    @Column(nullable = false) private String email;
    @Column(nullable = false) int telefone;
    @Column private boolean ativo;
    @Column private String endereco;
}
