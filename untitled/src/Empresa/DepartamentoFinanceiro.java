package Empresa;

import Funcionarios.Funcionario;
import Funcionarios.Caixa;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoFinanceiro extends Empresa {
    private final List<Funcionario> funcionariosFinanceiro;
    private final List<Caixa> caixas;

    public DepartamentoFinanceiro(String nome, String cnpj, String endereco, String telefone) {
        super(nome, cnpj, endereco, telefone);
        this.funcionariosFinanceiro = new ArrayList<>();
        this.caixas = new ArrayList<>();
    }

    public void adicionarFuncionarioFinanceiro(Funcionario f) {
        funcionariosFinanceiro.add(f);
        super.contratarFuncionario(f);
        System.out.println("Funcionário " + f.getNome() + " adicionado ao Departamento Financeiro.");
    }

    public void removerFuncionarioFinanceiro(Funcionario f) {
        if (funcionariosFinanceiro.remove(f)) {
            super.demitirFuncionario(f);
            System.out.println("Funcionário " + f.getNome() + " removido do Departamento Financeiro.");
        }
    }

    public void adicionarCaixa(Caixa c) {
        caixas.add(c);
        super.contratarFuncionario(c);
        System.out.println("Caixa " + c.getNome() + " adicionado ao Departamento Financeiro.");
    }

    public void removerCaixa(Caixa c) {
        if (caixas.remove(c)) {
            super.demitirFuncionario(c);
            System.out.println("Caixa " + c.getNome() + " removido do Departamento Financeiro.");
        }
    }

    public double calcularTotalCaixas() {
        return caixas.stream().mapToDouble(Caixa::getTotalDinheiroCaixa).sum();
    }

    public void exibirRelatorioFinanceiro() {
        System.out.println("\n=== Relatório Financeiro da Empresa " + super.getNome() + " ===");
        System.out.println("Total de Funcionários Financeiros: " + funcionariosFinanceiro.size());
        System.out.println("Total de Caixas: " + caixas.size());
        System.out.println("Saldo total em caixas: R$ " + calcularTotalCaixas());
    }

    public List<Funcionario> getFuncionariosFinanceiro() { return funcionariosFinanceiro; }
    public List<Caixa> getCaixas() { return caixas; }
}
