package com.example.demo.model.Cliente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
@Table(name = "tb_clientenovo") //abaixo os atributos do cliente foi herdado, o id é totalmente gerado
public class ClienteNovo extends Cliente implements Serializable {

    @Column(nullable = false)
    private int pontuacaoInicial;

    @Column(nullable = false)
    private boolean primeiraCompra;

    public ClienteNovo() {
        super();
    }

    public ClienteNovo(String nome, String cpf, String email, String numero, int pontuacaoInicial, boolean primeiraCompra) {
        super(nome, cpf, email, numero);
        this.pontuacaoInicial = pontuacaoInicial;
        this.primeiraCompra = primeiraCompra;
    }


    public int getPontuacaoInicial() {
        return pontuacaoInicial;
    }

    public void setPontuacaoInicial(int pontuacaoInicial) {
        this.pontuacaoInicial = pontuacaoInicial;
    }

    public boolean isPrimeiraCompra() {
        return primeiraCompra;
    }

    public void setPrimeiraCompra(boolean primeiraCompra) {
        this.primeiraCompra = primeiraCompra;
    }
}

