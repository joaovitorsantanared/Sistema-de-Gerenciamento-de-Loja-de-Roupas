package com.example.demo.repository;

import com.example.demo.model.Cliente.ClienteFidelidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteFidelidadeRepository extends JpaRepository<ClienteFidelidade, Long> {
    boolean existsByCpf(String cpf);
}
