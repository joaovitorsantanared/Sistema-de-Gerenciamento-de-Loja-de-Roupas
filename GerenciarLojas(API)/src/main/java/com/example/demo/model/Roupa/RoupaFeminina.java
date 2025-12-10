package com.example.demo.model.Roupa;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "roupafeminina_table")
public class RoupaFeminina extends Roupa {

    private String tipoPeca;
    private String tipoTecido;

    public RoupaFeminina() {}

    public RoupaFeminina(String nome, double preco, String tamanho, String cor, String marca,
                         int quantidadeEstoque, String tipoPeca, String tipoTecido) {
        super(nome, preco, tamanho, cor, marca, quantidadeEstoque);
        this.tipoPeca = tipoPeca;
        this.tipoTecido = tipoTecido;
    }

    public String getTipoPeca() {
        return tipoPeca;
    }

    public void setTipoPeca(String tipoPeca) {
        this.tipoPeca = tipoPeca;
    }

    public String getTipoTecido() {
        return tipoTecido;
    }

    public void setTipoTecido(String tipoTecido) {
        this.tipoTecido = tipoTecido;
    }
}