package Empresa;

import Funcionarios.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private final String nome;
    private final String cnpj;
    private String endereco;
    private String telefone;
    private String tipo; // (matriz, filial ou unidade)
    private final List<String> departamentos;
    private final List<Funcionario> funcionarios;

    public Empresa(String nome, String cnpj, String endereco, String telefone, String tipo) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
        this.tipo = tipo;
        this.departamentos = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
    }

    public void adicionarDepartamento(String nomeDepartamento) {
        departamentos.add(nomeDepartamento);
    }

    public void contratarFuncionario(Funcionario f) {
        if (!funcionarios.contains(f)) {
            funcionarios.add(f);
        }
    }

    public String getNome() { return nome; }
    public String getCnpj() { return cnpj; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public List<String> getDepartamentos() { return departamentos; }
    public List<Funcionario> getFuncionarios() { return funcionarios; }
}
