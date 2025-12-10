package com.example.demo.model.Venda;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "vendaspresencial_table")
public class VendasPresencial extends Venda {

    private boolean entregaImediata;

    public VendasPresencial() {
    }

    public VendasPresencial(Long id, LocalDate data, Double valorTotal, String formaPagamento,
                            boolean entregaImediata) {
        super(id, data, valorTotal, formaPagamento);
        this.entregaImediata = entregaImediata;
    }

    public boolean isEntregaImediata() {
        return entregaImediata;
    }

    public void setEntregaImediata(boolean entregaImediata) {
        this.entregaImediata = entregaImediata;
    }
}
