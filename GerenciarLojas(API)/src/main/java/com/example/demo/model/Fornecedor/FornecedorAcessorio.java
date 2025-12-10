package com.example.demo.model.Fornecedor;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "fornecedoracessorio_table")
public class FornecedorAcessorio extends Fornecedor {

    private String material;

    public FornecedorAcessorio() {
        
    }

    public FornecedorAcessorio(Long id, String nome, String cnpj, String email, String telefone, String endereco,
                               String tipoProdutoFornecido, String material) {
        super(id, nome, cnpj, email, telefone, endereco, tipoProdutoFornecido);
        this.material = material;
    }

    public String getMaterial() {
        return material; 
    }
    public void setMaterial(String material) {
        this.material = material;
    }
}
