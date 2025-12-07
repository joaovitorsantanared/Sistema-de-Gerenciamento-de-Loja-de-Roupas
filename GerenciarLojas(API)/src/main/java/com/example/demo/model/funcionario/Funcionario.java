package com.example.demo.model.funcionario;

import com.example.demo.model.empresa.Empresa;
import jakarta.persistence.*;
import java.time.LocalDate;


@MappedSuperclass
public abstract class Funcionario {
    //ATRIBUTOS

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(unique = true, nullable = false)
    private String cpf;
    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;
    @Column(name = "data_contratacao", nullable = false)
    private LocalDate dataContratacao;
    @Column(name = "salario_base", nullable = false)
    private double salarioBase;
    @Column(nullable = false)
    private String cargo;
    @Column(nullable = false)
    private boolean ativo;
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;


    //CONSTRUTOR
    public Funcionario(String nome, String cpf, LocalDate dataNascimento, LocalDate dataContratacao, double salarioBase, String cargo, boolean ativo) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.dataContratacao = dataContratacao;
        this.salarioBase = salarioBase;
        this.cargo = cargo;
        this.ativo = ativo;
    }

    //CONSTRUTOR VAZIO
    public Funcionario() {
    }

    //GETTER'S E SETTER'S
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {return nome;}
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public LocalDate getDataContratacao() {
        return dataContratacao;
    }
    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }
    public double getSalarioBase() {
        return salarioBase;
    }
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public boolean isAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    public Empresa getEmpresa() {return empresa;}
    public void setEmpresa(Empresa empresa) {this.empresa = empresa;}


    //TO STRING
    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", CPF: " + cpf +
                ", Cargo: " + cargo + ", Salário Base: " + salarioBase;
    }
    //CALCULAR SALÁRIO
    public abstract double calcularSalario();
}
