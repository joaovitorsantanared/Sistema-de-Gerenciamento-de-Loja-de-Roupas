package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Venda.VendasOnline;
import java.util.List;

public interface VendasOnlineRepository extends JpaRepository<VendasOnline, Long> {

    // Buscar vendas online por status do pedido
    List<VendasOnline> findByStatusPedido(String statusPedido);

    // Buscar vendas online por nome do cliente
    List<VendasOnline> findByNomeCliente(String nomeCliente);

    // Buscar vendas online por parte do endereço de entrega
    List<VendasOnline> findByEnderecoEntregaContaining(String enderecoEntrega);
}
