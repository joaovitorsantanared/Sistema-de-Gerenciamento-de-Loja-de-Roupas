package com.example.demo.service;

import com.example.demo.model.funcionario.Vendedor;
import com.example.demo.repository.EmpresaRepository;
import com.example.demo.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.empresa.Empresa;


import java.util.List;
import java.util.Optional;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private EmpresaRepository empresaRepository;


    // GET
    public List<Vendedor> getAll() {
        return vendedorRepository.findAll();
    }

    public Optional<Vendedor> getById(Long id) {
        return vendedorRepository.findById(id);
    }

    // POST
    public Vendedor save(Vendedor vendedor) {
        vendedor.setCargo("Vendedor");
        if (vendedor.getEmpresa() != null && vendedor.getEmpresa().getId() != null) {
            Empresa empresa = empresaRepository.findById(vendedor.getEmpresa().getId())
                    .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));
            vendedor.setEmpresa(empresa);
        } else {
            throw new RuntimeException("Empresa precisa ser informada");
        }
        return vendedorRepository.save(vendedor);
    }


    // PUT
    public Vendedor update(Long id, Vendedor vendedorAtualizado) {
        Vendedor existente = vendedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendedor não encontrado"));

        existente.setNome(vendedorAtualizado.getNome());
        existente.setCpf(vendedorAtualizado.getCpf());
        existente.setDataNascimento(vendedorAtualizado.getDataNascimento());
        existente.setDataContratacao(vendedorAtualizado.getDataContratacao());
        existente.setAtivo(vendedorAtualizado.isAtivo());
        existente.setComissao(vendedorAtualizado.getComissao());
        if (vendedorAtualizado.getEmpresa() != null && vendedorAtualizado.getEmpresa().getId() != null) {
            Empresa empresa = empresaRepository.findById(vendedorAtualizado.getEmpresa().getId())
                    .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));
            existente.setEmpresa(empresa);
        }
        return vendedorRepository.save(existente);
    }

    //DELETE
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
