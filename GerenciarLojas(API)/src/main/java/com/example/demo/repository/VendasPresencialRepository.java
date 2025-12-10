package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Venda.VendasPresencial;
import java.util.List;

public interface VendasPresencialRepository extends JpaRepository<VendasPresencial, Long> {

    // Buscar vendas presenciais com entrega imediata
    List<VendasPresencial> findByEntregaImediataTrue();

    // Buscar vendas presenciais sem entrega imediata
    List<VendasPresencial> findByEntregaImediataFalse();
}
