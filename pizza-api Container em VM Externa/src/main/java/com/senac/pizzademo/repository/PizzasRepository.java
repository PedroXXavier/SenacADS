package com.senac.pizzademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.pizzademo.model.Pizza;

@Repository
public interface PizzasRepository extends JpaRepository<Pizza, Long> {

}
