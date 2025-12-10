package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Roupa.Camiseta;

public interface CamisetaRepository extends JpaRepository<Camiseta, Long>{
    
}
