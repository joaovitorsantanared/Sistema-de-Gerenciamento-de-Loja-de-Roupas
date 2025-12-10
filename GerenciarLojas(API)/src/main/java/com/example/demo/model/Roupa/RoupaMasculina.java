package com.example.demo.model.Roupa;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "roupamasculina_table")
public class RoupaMasculina extends Roupa {

    private String tipoPeca;
    private String material;

    public RoupaMasculina() {}

    public RoupaMasculina(String nome, double preco, String tamanho, String cor, String marca,
                          int quantidadeEstoque, String tipoPeca, String material) {
        super(nome, preco, tamanho, cor, marca, quantidadeEstoque);
        this.tipoPeca = tipoPeca;
        this.material = material;
    }

    public String getTipoPeca() {
        return tipoPeca;
    }

    public void setTipoPeca(String tipoPeca) {
        this.tipoPeca = tipoPeca;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

}