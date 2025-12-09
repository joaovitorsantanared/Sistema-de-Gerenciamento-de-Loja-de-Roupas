package com.example.demo.model.Fornecedor;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "fornecedornacional_table")
public class FornecedorNacional extends Fornecedor {

    private Double impostoNacional;

    public FornecedorNacional() {
        
    }

    public FornecedorNacional(Long id, String nome, String cnpj, String email, String telefone, String endereco,
                              String tipoProdutoFornecido, Double impostoNacional) {
        super(id, nome, cnpj, email, telefone, endereco, tipoProdutoFornecido);
        this.impostoNacional = impostoNacional;
    }

    public Double getImpostoNacional() {
        return impostoNacional;
    }
    public void setImpostoNacional(Double impostoNacional) {
        this.impostoNacional = impostoNacional;
    }
}
