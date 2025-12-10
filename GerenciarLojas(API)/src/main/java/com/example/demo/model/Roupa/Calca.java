package com.example.demo.model.Roupa;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "calca_table")
public class Calca extends Roupa {

    private String modeloCalca;


    public Calca(Long id, String nome, double preco, String tamanho, String cor, String marca, int quantidadeEstoque, String modeloCalca) {
        super( nome, preco, tamanho, cor, marca, quantidadeEstoque);
        this.modeloCalca = modeloCalca;
    }
    
    public String getModeloCalca() {
        return modeloCalca;
    }


    public void setModeloCalca(String modeloCalca) {
        this.modeloCalca = modeloCalca;
    }

    public static List<Calca> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    public static Calca save(Calca calca) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }


    
}
