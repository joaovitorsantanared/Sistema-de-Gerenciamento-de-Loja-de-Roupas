package com.example.demo.repository;

import com.example.demo.model.Fornecedor.FornecedorTecidos;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FornecedorTecidosRepository extends JpaRepository<FornecedorTecidos, Long> {

    // Buscar fornecedores com gramatura maior que um valor
    List<FornecedorTecidos> findByGramaturaGreaterThan(Double gramatura);

    // Buscar fornecedores por lista de tipos de produto fornecido
    List<FornecedorTecidos> findByTipoProdutoFornecidoIn(List<String> tiposSustentaveis);
}
