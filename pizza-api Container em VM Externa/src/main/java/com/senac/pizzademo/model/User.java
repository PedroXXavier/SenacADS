package com.senac.pizzademo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column @Id private Long id;
    @Column(nullable = false) private String nome;
    @Column(nullable = false) private int idade;
    @Column(nullable = false) private String email;
    @Column private float saldoConta;

}