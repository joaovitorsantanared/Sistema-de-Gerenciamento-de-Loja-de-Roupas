package com.example.demo.model.empresa;

import jakarta.persistence.*;



@Entity
@Table(name = "TB_EMPRESA")
public class Empresa {

    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(unique = true, nullable = false)
    private String cnpj;
    @Column(nullable = false)
    private String telefone;
    @Column(name = "tipo_empresa", nullable = false)
    private String tipo;


    //CONSTRUTOR

    public Empresa(String nome, String cnpj, String telefone, String tipo) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.tipo = tipo;
    }
    //CONSTRUTOR VAZIO
    public Empresa() {}



    //GETTER'S E SETTER'S
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

}
