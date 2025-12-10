package com.example.demo.model.Roupa;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Roupa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private double preco;
    private String tamanho;
    private String cor;
    private String marca;
    private int quantidadeEstoque;

    protected Roupa() {}

    protected Roupa(String nome, double preco, String tamanho, String cor, String marca, int quantidadeEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.tamanho = tamanho;
        this.cor = cor;
        this.marca = marca;
        this.quantidadeEstoque = quantidadeEstoque;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
}