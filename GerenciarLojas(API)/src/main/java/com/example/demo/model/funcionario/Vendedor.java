package com.example.demo.model.funcionario;

import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "TB_VENDEDOR")
public class Vendedor extends Funcionario {
    //ATRIBUTOS
    @Column(nullable = false)
    private double comissao;
    @Column(name = "total_vendas")
    private double totalVendas = 0;


    //CONSTRUTOR
    public Vendedor(String nome, String cpf, LocalDate dataNascimento, LocalDate dataContratacao, boolean ativo, double comissao) {
        super(nome, cpf, dataNascimento, dataContratacao, 1500.0, "Vendedor", ativo);
        this.comissao = comissao;
    }

    public Vendedor() {

    }

    //O VENDEDOR RECEBE SEU SALÁRIO DE ACORDO COM A COMISSÃO
    @Override
    public double calcularSalario() {
        return getSalarioBase() + (totalVendas * comissao);
    }

    //GETTER'S E SETTER'S
    public double getComissao() {
        return comissao;
    }
    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    //MÉTODO PARA REGISTAR VENDA
    public void registrarVenda(double valor) {
        totalVendas += valor;
        System.out.println("Venda registrada no valor de R$ " + valor);
    }

    //GETTER'S E SETTER'S
    public double getTotalVendas() {
        return totalVendas;
    }
}
