package com.example.demo.model.Venda;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "vendasonline_table")
@PrimaryKeyJoinColumn(name = "venda_id")
public class VendasOnline extends Venda {

    private String enderecoEntrega;
    private String statusPedido;
    private String nomeCliente;

    public VendasOnline() {
    }

    public VendasOnline(Long id, LocalDate data, Double valorTotal, String formaPagamento,
                        String enderecoEntrega, String statusPedido, String nomeCliente) {
        super(id, data, valorTotal, formaPagamento);
        this.enderecoEntrega = enderecoEntrega;
        this.statusPedido = statusPedido;
        this.nomeCliente = nomeCliente;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega; 
    }
    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega; 
    }

    public String getStatusPedido() {
        return statusPedido; 
    }
    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido; 
    }

    public String getNomeCliente() {
        return nomeCliente; 
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente; 
    }
}
