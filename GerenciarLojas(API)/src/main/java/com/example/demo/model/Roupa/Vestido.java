package com.example.demo.model.Roupa;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "vestido_table")
public class Vestido extends Roupa{

    private String comprimento;

    public Vestido(Long id, String nome, double preco, String tamanho, String cor, String marca,
            int quantidadeEstoque, String comprimento) {
        super( nome, preco, tamanho, cor, marca, quantidadeEstoque);
        this.comprimento = comprimento;

    }
    
    public String getComprimento() {
        return comprimento;
    }


    public void setComprimento(String comprimento) {
        this.comprimento = comprimento;
    }

    public static List<Vestido> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    public static Vestido save(Vestido vestido) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }


    
}
