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
public class Pedido {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column @Id private Long id;
    @Column(nullable = false) private String numero;
    @Column(nullable = false) private Pizza[] pizzas;
    @Column(nullable = false) private float total;
}
