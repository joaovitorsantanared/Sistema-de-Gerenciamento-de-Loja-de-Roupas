package Empresa;

import Funcionarios.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class DepartamentoFinanceiro extends Empresa {
    private final List<Funcionario> funcionariosFinanceiro;

    public DepartamentoFinanceiro(String nome, String cnpj, String endereco, String telefone) {
        super(nome, cnpj, endereco, telefone);
        this.funcionariosFinanceiro = new ArrayList<>();
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


    public void exibirRelatorioFinanceiro() {
        System.out.println("\n=== Relatório Financeiro da Empresa " + super.getNome() + " ===");
        System.out.println("Total de Funcionários Financeiros: " + funcionariosFinanceiro.size());
    }

    public List<Funcionario> getFuncionariosFinanceiro() { return funcionariosFinanceiro; }
}
