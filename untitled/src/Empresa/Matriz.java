package Empresa;

import Funcionarios.Gerente;

public class Matriz extends UnidadeEmpresa {

    public Matriz(String nome, String cnpj, String endereco, String telefone, Gerente gerente) {
        super(nome, cnpj, endereco, telefone, gerente);
    }

    public void exibirRelatorioCompleto() {
        System.out.println("=== Relatório da Matriz ===");
        System.out.println("Gerente: " + getGerenteResponsavel().getNome());
        System.out.println("Número de funcionários: " + getFuncionariosUnidade().size());
        double totalVendas = getVendasUnidade().stream().mapToDouble(v -> v.getValorTotal()).sum();
        System.out.printf("Total de vendas do mês: R$ %.2f%n", totalVendas);
    }
}
