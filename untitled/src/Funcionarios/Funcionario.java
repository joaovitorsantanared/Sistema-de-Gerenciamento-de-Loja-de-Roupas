package Funcionarios;
import java.time.LocalDate;

public abstract class Funcionario {
    //ATRIBUTOS
    private int id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private LocalDate dataContratacao;
    private double salarioBase;
    private String cargo;
    private boolean ativo;


    //CONSTRUTOR
    public Funcionario(int id, String nome, String cpf, LocalDate dataNascimento, LocalDate dataContratacao, double salarioBase, String cargo, boolean ativo) {
        this.id = id;
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
    public int getId() {
        return id;
    }
    public void setId(int id) {
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


    //CALCULAR SALÁRIO
    public abstract double calcularSalario();


    //TO STRING
    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", CPF: " + cpf +
                ", Cargo: " + cargo + ", Salário Base: " + salarioBase;
    }
}
