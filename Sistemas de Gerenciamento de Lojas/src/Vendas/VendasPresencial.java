package Vendas;

import java.time.LocalDate;

public class VendasPresencial extends Vendas {
    private boolean entregaImediata;

    public VendasPresencial(String id, LocalDate data, Double valorTotal, String formaPagamento,
        boolean entregaImediata) {
        super(id, data, valorTotal, formaPagamento);
        setEntregaImediata(entregaImediata);
    }

    public boolean isEntregaImediata() {
        return entregaImediata;
    }

    public void setEntregaImediata(boolean entregaImediata) {
        this.entregaImediata = entregaImediata;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Entrega Imediata: " + (entregaImediata ? "Sim" : "Não"));
    }
}
