package Empresa;

import Funcionarios.Funcionario;
import Funcionarios.Gerente;
import Vendas.Vendas;
import java.util.ArrayList;
import java.util.List;

public class UnidadeEmpresa extends Empresa {
    private final Gerente gerenteResponsavel;
    private final List<Funcionario> funcionariosUnidade;
    private final List<Vendas> vendasUnidade;

    public UnidadeEmpresa(String nome, String cnpj, String endereco, String telefone, Gerente gerente) {
        super(nome, cnpj, endereco, telefone);
        this.gerenteResponsavel = gerente;
        this.funcionariosUnidade = new ArrayList<>();
        this.vendasUnidade = new ArrayList<>();
        adicionarFuncionario(gerente);
    }

    public void adicionarFuncionario(Funcionario f) {
        if (!funcionariosUnidade.contains(f)) {
            funcionariosUnidade.add(f);
            super.contratarFuncionario(f);
            System.out.println("Funcionário " + f.getNome() + " adicionado na unidade " + getNome());
        }
    }

    public void demitirFuncionario(Funcionario f) {
        if (funcionariosUnidade.remove(f)) {
            super.demitirFuncionario(f);
            System.out.println("Funcionário " + f.getNome() + " removido da unidade " + getNome());
        }
    }

    public void registrarVenda(Vendas v) {
        vendasUnidade.add(v);
        System.out.println("Venda registrada na unidade " + getNome() + " no valor de R$ " + v.getValorTotal());
    }

    public Gerente getGerenteResponsavel() { return gerenteResponsavel; }
    public List<Funcionario> getFuncionariosUnidade() { return funcionariosUnidade; }
    public List<Vendas> getVendasUnidade() { return vendasUnidade; }
}
