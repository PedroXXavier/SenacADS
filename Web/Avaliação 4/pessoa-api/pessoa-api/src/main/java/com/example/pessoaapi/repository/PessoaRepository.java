package com.example.pessoaapi.repository;

import com.example.pessoaapi.entity.Pessoa;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Transactional
    @Modifying
    @Query("update Pessoa p set p.ativo = true where  p.id = ?1")
    void ativarStatus(Long id);
}
