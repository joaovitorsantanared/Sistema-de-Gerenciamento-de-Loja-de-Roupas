package com.example.demo.repository;

import com.example.demo.model.Fornecedor.FornecedorInternacional;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FornecedorInternacionalRepository extends JpaRepository<FornecedorInternacional, Long> {

    // Buscar fornecedores internacionais com taxa de importação maior que um valor
    List<FornecedorInternacional> findByTaxaImportacaoGreaterThan(Double taxa);

    // Buscar fornecedores internacionais pelo endereço (ex: país de origem)
    List<FornecedorInternacional> findByEnderecoContainingIgnoreCase(String endereco);
}
