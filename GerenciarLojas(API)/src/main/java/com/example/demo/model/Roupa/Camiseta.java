package com.example.demo.model.Roupa;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "camiseta_table")
public class Camiseta extends Roupa{

        private String tipoGola;

    public Camiseta(Long id, String nome, double preco, String tamanho, String cor, String marca,
            int quantidadeEstoque, String tipoGola) {
        super(id, nome, preco, tamanho, cor, marca, quantidadeEstoque);
        this.tipoGola = tipoGola;
    }
    
     public String getTipoGola() {
            return tipoGola;
        }


        public void setTipoGola(String tipoGola) {
            this.tipoGola = tipoGola;
        }

        public static List<Camiseta> findAll() {
            throw new UnsupportedOperationException("Unimplemented method 'findAll'");
        }

        public static Camiseta save(Camiseta camiseta) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'save'");
        }
}
