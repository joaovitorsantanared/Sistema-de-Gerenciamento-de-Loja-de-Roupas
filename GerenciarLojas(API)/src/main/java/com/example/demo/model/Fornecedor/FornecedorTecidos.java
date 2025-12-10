package com.example.demo.model.Fornecedor;

import jakarta.persistence.Entity;

import jakarta.persistence.Table;


@Entity
@Table(name = "fornecedortecido_table")
public class FornecedorTecidos extends Fornecedor {

    private Double gramatura;

    public FornecedorTecidos() {
        
    }

    public FornecedorTecidos(Long id, String nome, String cnpj, String email, String telefone, String endereco,
                             String tipoProdutoFornecido, Double gramatura) {
        super(id, nome, cnpj, email, telefone, endereco, tipoProdutoFornecido);
        this.gramatura = gramatura;
    }

    public Double getGramatura() {
        return gramatura; 
    }
    public void setGramatura(Double gramatura) {
        this.gramatura = gramatura; 
    }
}
