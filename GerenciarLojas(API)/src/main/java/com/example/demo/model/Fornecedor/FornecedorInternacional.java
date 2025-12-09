package com.example.demo.model.Fornecedor;

import jakarta.persistence.*;


@Entity
@Table(name = "fornecedorinternacional_table")
public class FornecedorInternacional extends Fornecedor {

    private Double taxaImportacao;

    public FornecedorInternacional() {

    }

    public FornecedorInternacional(Long id, String nome, String cnpj, String email, String telefone, String endereco,
                                   String tipoProdutoFornecido, Double taxaImportacao) {
        super(id, nome, cnpj, email, telefone, endereco, tipoProdutoFornecido);
        this.taxaImportacao = taxaImportacao;
    }

    public Double getTaxaImportacao() {
        return taxaImportacao; 
    }
    public void setTaxaImportacao(Double taxaImportacao) {
        this.taxaImportacao = taxaImportacao;
    }
}
