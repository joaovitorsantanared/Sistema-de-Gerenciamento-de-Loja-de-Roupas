package com.example.demo.repository;

import com.example.demo.model.Fornecedor.FornecedorAcessorio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FornecedorAcessorioRepository extends JpaRepository<FornecedorAcessorio, Long> {

    // Buscar fornecedores de acessórios por material (case insensitive)
    List<FornecedorAcessorio> findByMaterialIgnoreCase(String material);

    // Buscar fornecedores de acessórios por lista de materiais recicláveis
    List<FornecedorAcessorio> findByMaterialIn(List<String> materiaisReciclaveis);
}
