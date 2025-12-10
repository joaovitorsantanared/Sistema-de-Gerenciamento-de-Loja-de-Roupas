package com.example.demo.model.Fornecedor;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cnpj;
    private String email;
    private String telefone;
    private String endereco;
    private String tipoProdutoFornecido;

    public Fornecedor(){
        
    }

    public Fornecedor(Long id, String nome, String cnpj, String email, String telefone, String endereco,
                      String tipoProdutoFornecido) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.tipoProdutoFornecido = tipoProdutoFornecido;
    }

    public Long getId() {
        return id; 
    }
    public void setId(Long id) {
        this.id = id; 
    }

    public String getNome() {
        return nome; 
    }
    public void setNome(String nome) {
        this.nome = nome; 
    }

    public String getCnpj() {
        return cnpj; 
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj; 
    }

    public String getEmail() {
        return email; 
    }
    public void setEmail(String email) {
        this.email = email; 
    }

    public String getTelefone() {
        return telefone; 
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone; 
    }

    public String getEndereco() {
        return endereco; 
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco; 
    }

    public String getTipoProdutoFornecido() {
        return tipoProdutoFornecido; 
    }
    public void setTipoProdutoFornecido(String tipoProdutoFornecido) {
        this.tipoProdutoFornecido = tipoProdutoFornecido; 
    }
}
