package com.senac.pizzademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.pizzademo.model.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Long>{

}