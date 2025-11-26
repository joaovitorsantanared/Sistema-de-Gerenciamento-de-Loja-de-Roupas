package Empresa;

import Funcionarios.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private final String nome;
    private final String cnpj;
    private String endereco;
    private String telefone;
    private final List<String> departamentos;
    private final List<Funcionario> funcionarios;

    public Empresa(String nome, String cnpj, String endereco, String telefone) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
        this.departamentos = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
    }

    public void adicionarDepartamento(String nomeDepartamento) {
        departamentos.add(nomeDepartamento);
        System.out.println("Departamento " + nomeDepartamento + " adicionado à empresa " + nome);
    }

    public void exibirDepartamentos() {
        System.out.println("Departamentos da empresa " + nome + ":");
        for (String d : departamentos) {
            System.out.println("- " + d);
        }
    }

    public void contratarFuncionario(Funcionario f) {
        if (!funcionarios.contains(f)) {
            funcionarios.add(f);
            System.out.println("Novo funcionário contratado: " + f.getNome() + ". Total agora: " + funcionarios.size());
        }
    }

    public void demitirFuncionario(Funcionario f) {
        if (funcionarios.remove(f)) {
            System.out.println("Funcionário " + f.getNome() + " desligado. Total agora: " + funcionarios.size());
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public String getCnpj() { return cnpj; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public List<String> getDepartamentos() { return departamentos; }
    public List<Funcionario> getFuncionarios() { return funcionarios; }
    public int getQuantidadeFuncionarios() { return funcionarios.size(); }
}
