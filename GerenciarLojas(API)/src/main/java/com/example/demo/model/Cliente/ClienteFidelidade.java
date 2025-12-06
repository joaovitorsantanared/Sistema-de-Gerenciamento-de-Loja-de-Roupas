package com.example.demo.model.Cliente;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_clientefidelidade")
public class ClienteFidelidade extends Cliente {

    @Column(nullable = false)
    private int pontosFidelidade;

    @Column(name = "nivel_fidelidade", nullable = false)
    private int nivelFidelidade = 0; // nível padrão Bronze

    public ClienteFidelidade() {
        super();
        this.nivelFidelidade = 0;
    }

    public ClienteFidelidade(String nome, String cpf, String email, String numero, int pontosFidelidade, int nivelFidelidade) {
        super(nome, cpf, email, numero);
        this.pontosFidelidade = pontosFidelidade;
        this.nivelFidelidade = nivelFidelidade;
    }

    public int getPontosFidelidade() { return pontosFidelidade; }
    public void setPontosFidelidade(int pontosFidelidade) { this.pontosFidelidade = pontosFidelidade; }

    public int getNivelFidelidade() { return nivelFidelidade; }
    public void setNivelFidelidade(int nivelFidelidade) { this.nivelFidelidade = nivelFidelidade; }
}
