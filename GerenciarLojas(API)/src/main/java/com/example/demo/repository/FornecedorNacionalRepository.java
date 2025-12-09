package com.example.demo.repository;

import com.example.demo.model.Fornecedor.FornecedorNacional;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FornecedorNacionalRepository extends JpaRepository<FornecedorNacional, Long> {

    // Buscar fornecedores com imposto nacional maior que um valor
    List<FornecedorNacional> findByImpostoNacionalGreaterThan(Double imposto);

    // Buscar fornecedores que possuem CNPJ preenchido
    List<FornecedorNacional> findByCnpjIsNotNull();
}
