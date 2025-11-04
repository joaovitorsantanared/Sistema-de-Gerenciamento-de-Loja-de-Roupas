package Empresa;

import Funcionarios.Gerente;
import Vendas.Vendas;

public class Filial extends UnidadeEmpresa {
    private final int numeroFilial;

    public Filial(String nome, String cnpj, String endereco, String telefone, int numeroFilial, Gerente gerente) {
        super(nome, cnpj, endereco, telefone, gerente);
        this.numeroFilial = numeroFilial;
    }

    public int getNumeroFilial() { return numeroFilial; }

    public void exibirRelatorioCompleto() {
        System.out.println("=== Relatório da Filial " + numeroFilial + " ===");
        System.out.println("Gerente: " + getGerenteResponsavel().getNome());
        System.out.println("Número de funcionários: " + getFuncionariosUnidade().size());
        double totalVendas = getVendasUnidade().stream().mapToDouble(Vendas::getValorTotal).sum();
        System.out.printf("Total de vendas do mês: R$ %.2f%n", totalVendas);
    }
}
