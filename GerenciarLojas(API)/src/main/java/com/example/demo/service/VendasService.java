package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.model.Venda.VendasOnline;
import com.example.demo.model.Venda.VendasPresencial;
import com.example.demo.repository.VendasOnlineRepository;
import com.example.demo.repository.VendasPresencialRepository;

@Service
public class VendasService {


    @Autowired
    private VendasOnlineRepository vendasOnlineRepository;

    @Autowired
    private VendasPresencialRepository vendasPresencialRepository;

    // Listar
    public List<VendasOnline> getAllVendasOnline() {
        return vendasOnlineRepository.findAll(); 
    }

    public List<VendasPresencial> getAllVendasPresenciais() {
        return vendasPresencialRepository.findAll(); 
    }

    // Criar
    public VendasOnline saveVendasOnline(VendasOnline vendasOnline) {
        return vendasOnlineRepository.save(vendasOnline); 
    }

    public VendasPresencial saveVendasPresencial(VendasPresencial vendasPresencial) {
        return vendasPresencialRepository.save(vendasPresencial); 
    }

    // Deletar
    public void deleteVendasOnline(Long id) {
        vendasOnlineRepository.deleteById(id); 
    }

    public void deleteVendasPresenciais(Long id) {
        vendasPresencialRepository.deleteById(id); 
    }

    //Atualizar
    public VendasOnline updateVendasOnline(Long id, VendasOnline vendaOnlineAtualizada) {
        validarDadosPedidoOnline(vendaOnlineAtualizada);
        return vendasOnlineRepository.findById(id)
            .map(vo -> {
                vo.setEnderecoEntrega(vendaOnlineAtualizada.getEnderecoEntrega());
                vo.setStatusPedido(vendaOnlineAtualizada.getStatusPedido());
                vo.setNomeCliente(vendaOnlineAtualizada.getNomeCliente());
                vo.setValorTotal(vendaOnlineAtualizada.getValorTotal());
                vo.setFormaPagamento(vendaOnlineAtualizada.getFormaPagamento());
                vo.setData(vendaOnlineAtualizada.getData());
                return vendasOnlineRepository.save(vo);
            })
            .orElseThrow(() -> new RuntimeException("Venda online não encontrada"));
    }

    public VendasPresencial updateVendasPresencial(Long id, VendasPresencial vendaPresencialAtualizada) {
        return vendasPresencialRepository.findById(id)
            .map(vp -> {
                vp.setEntregaImediata(vendaPresencialAtualizada.isEntregaImediata());
                vp.setValorTotal(vendaPresencialAtualizada.getValorTotal());
                vp.setFormaPagamento(vendaPresencialAtualizada.getFormaPagamento());
                vp.setData(vendaPresencialAtualizada.getData());
                return vendasPresencialRepository.save(vp);
            })
            .orElseThrow(() -> new RuntimeException("Venda presencial não encontrada"));
    }

    // Vendas Online
    public void validarDadosPedidoOnline(VendasOnline vendaOnline) {
        if (vendaOnline.getEnderecoEntrega() == null || vendaOnline.getEnderecoEntrega().trim().isEmpty()) {
            throw new IllegalArgumentException("Endereço de entrega não pode ser vazio.");
        }
        if (vendaOnline.getStatusPedido() == null || vendaOnline.getStatusPedido().trim().isEmpty()) {
            throw new IllegalArgumentException("Status do pedido não pode ser vazio.");
        }
        if (vendaOnline.getNomeCliente() == null || vendaOnline.getNomeCliente().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do cliente não pode ser vazio.");
        }
        vendasOnlineRepository.save(vendaOnline);
    }

// Vendas Online
public String exibirInformacoesOnline(VendasOnline vendaOnline) {
    String info = "Nome do Cliente: " + vendaOnline.getNomeCliente() +
                  "\nEndereço de Entrega: " + vendaOnline.getEnderecoEntrega() +
                  "\nStatus do Pedido: " + vendaOnline.getStatusPedido();

    System.out.println(info);
    
    return info;
    }

// Vendas Presencial
public String exibirInformacoesPresencial(VendasPresencial vendaPresencial) {
    String info = "Entrega Imediata: " + (vendaPresencial.isEntregaImediata() ? "Sim" : "Não");

    System.out.println(info);

    return info;
    }

}