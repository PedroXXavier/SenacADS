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
public class Pizza {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column @Id private Long id;
    @Column(nullable = false) private String sabor;
    @Column(nullable = false) private String tamanho;
    @Column(nullable = false) private String descricao;
    @Column(nullable = false) float precoTotal;
}

