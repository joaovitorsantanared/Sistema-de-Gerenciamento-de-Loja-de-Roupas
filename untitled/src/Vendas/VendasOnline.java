package Vendas;

import java.time.LocalDate;

public class VendasOnline extends Vendas {
    private String enderecoEntrega;
    private String statusPedido;
    private String nomeCliente;

    public VendasOnline(String id, LocalDate data, Double valorTotal, String formaPagamento,
                        String enderecoEntrega, String statusPedido, String nomeCliente) {
        super(id, data, valorTotal, formaPagamento);
        setEnderecoEntrega(enderecoEntrega);
        setStatusPedido(statusPedido);
        setNomeCliente(nomeCliente);
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        if (enderecoEntrega == null || enderecoEntrega.trim().isEmpty()) {
            throw new IllegalArgumentException("Endereço de entrega não pode ser vazio.");
        }
        this.enderecoEntrega = enderecoEntrega;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        if (statusPedido == null || statusPedido.trim().isEmpty()) {
            throw new IllegalArgumentException("Status do pedido não pode ser vazio.");
        }
        this.statusPedido = statusPedido;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        if (nomeCliente == null || nomeCliente.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do cliente não pode ser vazio.");
        }
        this.nomeCliente = nomeCliente;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Nome do Cliente: " + getNomeCliente());
        System.out.println("Endereço de Entrega: " + getEnderecoEntrega());
        System.out.println("Status do Pedido: " + getStatusPedido());
    }
}
