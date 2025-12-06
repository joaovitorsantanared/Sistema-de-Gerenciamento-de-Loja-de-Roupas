package com.example.demo.model.Cliente;

import jakarta.persistence.*;

import java.io.Serializable;

@MappedSuperclass
public abstract class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = false, length = 11, unique = true)
    private String cpf;
    @Column(nullable = false, length = 50, unique = true)
    private String email;
    @Column(nullable = false,length = 9, unique = true)
    private String numero;
    @Column(nullable = false)
    private boolean ative;

    public Cliente() {
    }

    public Cliente(String id, String nome, String cpf, String email, String numero) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.numero = numero;

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean isAtive() {
        return ative;
    }

    public void setAtive(boolean ative) {
        this.ative = ative;
    }
}