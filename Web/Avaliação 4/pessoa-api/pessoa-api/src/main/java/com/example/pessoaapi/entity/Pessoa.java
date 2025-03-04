package com.example.pessoaapi.entity;

import jakarta.persistence.*;
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
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false) private String nome;
    @Column(nullable = false) private String email;
    @Column(nullable = false) private String telefone;
    @Column private String endereco;
    @Column private boolean ativo;
}
