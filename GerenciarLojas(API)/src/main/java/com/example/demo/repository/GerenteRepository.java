package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.funcionario.Gerente;
import org.springframework.stereotype.Repository;


@Repository
public interface GerenteRepository extends JpaRepository<Gerente, Long> {
}
