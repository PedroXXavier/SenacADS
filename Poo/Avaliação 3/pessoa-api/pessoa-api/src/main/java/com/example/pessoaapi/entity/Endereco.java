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

@Table(name = "db-endereco")
@Entity

public class Endereco {
    @Column @Id private Long id;
    @Column private String logradouro;

    @Column private Long pessoaId;
}
