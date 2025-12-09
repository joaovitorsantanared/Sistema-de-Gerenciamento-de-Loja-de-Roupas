package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Roupa.Vestido;

public interface VestidoRepository extends JpaRepository<Vestido, Long>{
}
