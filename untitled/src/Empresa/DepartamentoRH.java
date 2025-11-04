package Empresa;

import Funcionarios.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoRH extends Empresa {
    private final List<Funcionario> funcionariosRH;

    public DepartamentoRH(String nome, String cnpj, String endereco, String telefone) {
        super(nome, cnpj, endereco, telefone);
        this.funcionariosRH = new ArrayList<>();
    }

    public void adicionarFuncionarioRH(Funcionario f) {
        funcionariosRH.add(f);
        super.contratarFuncionario(f);
        System.out.println("Funcionário " + f.getNome() + " adicionado ao Departamento de RH.");
    }

    public void removerFuncionarioRH(Funcionario f) {
        if (funcionariosRH.remove(f)) {
            super.demitirFuncionario(f);
            System.out.println("Funcionário " + f.getNome() + " removido do Departamento de RH.");
        }
    }

    public void listarFuncionariosRH() {
        System.out.println("=== Funcionários RH ===");
        for (Funcionario f : funcionariosRH) {
            System.out.println(f.getNome() + " - Cargo: " + f.getCargo());
        }
    }

    public void relatorioAtivos() {
        System.out.println("=== Funcionários Ativos RH ===");
        for (Funcionario f : funcionariosRH) {
            if (f.isAtivo()) {
                System.out.println(f.getNome() + " - Cargo: " + f.getCargo());
            }
        }
    }

    public List<Funcionario> getFuncionariosRH() { return funcionariosRH; }
}
