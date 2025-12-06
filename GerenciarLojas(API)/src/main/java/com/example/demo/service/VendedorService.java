package com.example.demo.service;

import com.example.demo.model.funcionario.Vendedor;
import com.example.demo.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    public List<Vendedor> getAll() {
        return vendedorRepository.findAll();
    }

    public Optional<Vendedor> getById(Long id) {
        return vendedorRepository.findById(id);
    }

    public Vendedor save(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }

    public Vendedor update(Long id, Vendedor vendedorAtualizado) {
        return vendedorRepository.findById(id).map(vendedor -> {
            vendedor.setNome(vendedorAtualizado.getNome());
            vendedor.setCpf(vendedorAtualizado.getCpf());
            vendedor.setDataNascimento(vendedorAtualizado.getDataNascimento());
            vendedor.setDataContratacao(vendedorAtualizado.getDataContratacao());
            vendedor.setSalarioBase(vendedorAtualizado.getSalarioBase());
            vendedor.setComissao(vendedorAtualizado.getComissao());
            vendedor.setAtivo(vendedorAtualizado.isAtivo());
            return vendedorRepository.save(vendedor);
        }).orElseGet(() -> {
            vendedorAtualizado.setId(id);
            return vendedorRepository.save(vendedorAtualizado);
        });
    }

    public void delete(Long id) {
        vendedorRepository.deleteById(id);
    }

    public Vendedor registrarVenda(Long id, double valor) {
        Vendedor vendedor = vendedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendedor não encontrado"));

        vendedor.registrarVenda(valor);
        return vendedorRepository.save(vendedor);
    }
}