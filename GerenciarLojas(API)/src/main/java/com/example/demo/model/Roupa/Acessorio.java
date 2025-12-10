package com.example.demo.model.Roupa;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "acessorio_table")
public class Acessorio extends Roupa{

    private String tipoAcessorio;
    private String material;      
    
    public Acessorio(Long id, String nome, double preco, String tamanho, String cor, String marca,
            int quantidadeEstoque, String tipoAcessorio, String material) {
        super( nome, preco, tamanho, cor, marca, quantidadeEstoque);
        this.tipoAcessorio = tipoAcessorio;
        this.material = material;

    }
    
    public String getTipoAcessorio() {
        return tipoAcessorio;
    }

    public void setTipoAcessorio(String tipoAcessorio) {
        this.tipoAcessorio = tipoAcessorio;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public static List<Acessorio> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    public static Acessorio save(Acessorio acessorio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }



}
