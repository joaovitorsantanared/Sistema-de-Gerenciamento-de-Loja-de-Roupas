package com.example.demo.service;

import com.example.demo.model.funcionario.Gerente;
import com.example.demo.repository.EmpresaRepository;
import com.example.demo.repository.GerenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.empresa.Empresa;


import java.util.List;
import java.util.Optional;

@Service
public class GerenteService {

    @Autowired
    private GerenteRepository gerenteRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    // GET
    public List<Gerente> getAll() {
        return gerenteRepository.findAll();
    }

    public Optional<Gerente> getById(Long id) {
        return gerenteRepository.findById(id);
    }


    // POST
    public Gerente save(Gerente gerente) {
        gerente.setCargo("Gerente");
        if (gerente.getEmpresa() != null && gerente.getEmpresa().getId() != null) {
            Empresa empresa = empresaRepository.findById(gerente.getEmpresa().getId())
                    .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));
            gerente.setEmpresa(empresa);
        } else {
            throw new RuntimeException("Empresa precisa ser informada");
        }
        return gerenteRepository.save(gerente);
    }


    // PUT
    public Gerente update(Long id, Gerente gerenteAtualizado) {
        Gerente existente = gerenteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gerente não encontrado"));

        existente.setNome(gerenteAtualizado.getNome());
        existente.setCpf(gerenteAtualizado.getCpf());
        existente.setDataNascimento(gerenteAtualizado.getDataNascimento());
        existente.setDataContratacao(gerenteAtualizado.getDataContratacao());
        existente.setAtivo(gerenteAtualizado.isAtivo());
        existente.setBonus(gerenteAtualizado.getBonus());
        if (gerenteAtualizado.getEmpresa() != null && gerenteAtualizado.getEmpresa().getId() != null) {
            Empresa empresa = empresaRepository.findById(gerenteAtualizado.getEmpresa().getId())
                    .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));
            existente.setEmpresa(empresa);
        }
        return gerenteRepository.save(existente);
    }


    // DELETE
    public void delete(Long id) {
        gerenteRepository.deleteById(id);
    }
}
