package Vendas;

import java.time.LocalDate;
import java.util.Scanner;
import Cliente.ClienteFidelidade;

public class Vendas {
    private ClienteFidelidade clienteFidelidade;
    private String id;
    private LocalDate data;
    private Double valorTotal;
    private String formaPagamento;

    public Vendas(String id, LocalDate data, Double valorTotal, String formaPagamento) {
        this.id = id;
        this.data = data;
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public void setClienteFidelidade(ClienteFidelidade clienteFidelidade) {
        this.clienteFidelidade = clienteFidelidade;
    }

    public void exibirInformacoes() {
        System.out.println("ID: " + getId());
        System.out.println("Data: " + getData());
        System.out.println("Valor Total: R$ " + String.format("%.2f", getValorTotal()));
        System.out.println("Forma de Pagamento: " + getFormaPagamento());
    }

    public void aplicarDescontoClienteFidelidade() {
        if (clienteFidelidade != null) {
            double valorComDesconto = valorTotal * 0.7;
            System.out.println("Desconto aplicado para cliente fidelidade.");
            System.out.printf("Valor original: R$ %.2f%n", valorTotal);
            System.out.printf("Valor com desconto: R$ %.2f%n", valorComDesconto);
            this.valorTotal = valorComDesconto;
        } else {
            System.out.println("Nenhum cliente fidelidade associado. Desconto não aplicado.");
        }
    }

    public void selecionarFormaPagamento() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual será sua forma de pagamento?");
        System.out.println("1 - PIX");
        System.out.println("2 - Débito");
        System.out.println("3 - Crédito");
        System.out.println("4 - Cédula");

        int escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        switch (escolha) {
            case 1:
                this.formaPagamento = "PIX";
                break;
            case 2:
                this.formaPagamento = "Débito";
                break;
            case 3:
                this.formaPagamento = "Crédito";
                break;
            case 4:
                this.formaPagamento = "Cédula";
                break;
            default:
                System.out.println("Opção inválida. Forma de pagamento definida como PIX por padrão.");
                this.formaPagamento = "PIX";
                break;
        }

        System.out.println("Forma de pagamento selecionada: " + this.formaPagamento);
    }
}
