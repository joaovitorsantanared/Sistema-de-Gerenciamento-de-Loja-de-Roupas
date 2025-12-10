package com.example.demo.model.Venda;

import jakarta.persistence.*;
import java.time.LocalDate;

import com.example.demo.model.Cliente.ClienteFidelidade;

@MappedSuperclass
public abstract class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private ClienteFidelidade clienteFidelidade;

    private LocalDate data;
    private Double valorTotal;
    private String formaPagamento;

    public Venda() {
    }

    public Venda(Long id, LocalDate data, Double valorTotal, String formaPagamento) {
        this.id = id;
        this.data = data;
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
    }

    public Long getId() {
        return id; 
    }
    public void setId(Long id) {
        this.id = id; 
    }

    public ClienteFidelidade getClienteFidelidade() {
        return clienteFidelidade; 
    }
    public void setClienteFidelidade(ClienteFidelidade clienteFidelidade) {
        this.clienteFidelidade = clienteFidelidade; 
    }

    public LocalDate getData() {
        return data; 
    }
    public void setData(LocalDate data) {
        this.data = data; 
    }

    public Double getValorTotal() {
        return valorTotal; 
    }
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal; 
    }

    public String getFormaPagamento() {
        return formaPagamento; 
    }
    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento; 
    }
}
