package com.example.demo.model.Roupa;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "roupafeminina_table")
public class RoupaFeminina extends Roupa{

    private String tipoPeca; 
    private String tipoTecido;



    public RoupaFeminina(Long id, String nome, double preco, String tamanho, String cor, String marca,
            int quantidadeEstoque, String tipoPeca, String tipoTecido) {
        super(id, nome, preco, tamanho, cor, marca, quantidadeEstoque);
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

    public static List<RoupaFeminina> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    public static RoupaFeminina save(RoupaFeminina roupaFeminina) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
}
