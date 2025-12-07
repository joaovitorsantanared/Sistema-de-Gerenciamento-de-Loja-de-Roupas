package com.example.demo.service;

import com.example.demo.model.empresa.Empresa;
import com.example.demo.repository.EmpresaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    // GET
    public List<Empresa> getAll() {
        return empresaRepository.findAll();
    }

    public Optional<Empresa> getById(Long id) {
        return empresaRepository.findById(id);
    }


    // POST
    public Empresa save(Empresa empresa) {
        return empresaRepository.save(empresa);
    }


    // PUT
    public Empresa update(Long id, Empresa empresaAtualizada) {
        return empresaRepository.findById(id)
                .map(empresa -> {
                    empresa.setNome(empresaAtualizada.getNome());
                    empresa.setCnpj(empresaAtualizada.getCnpj());
                    empresa.setTelefone(empresaAtualizada.getTelefone());
                    empresa.setTipo(empresaAtualizada.getTipo());
                    return empresaRepository.save(empresa);
                }).orElseThrow(() -> new RuntimeException("Empresa não encontrada com id " + id));
    }


    // DELETE
    public void delete(Long id) {
        empresaRepository.deleteById(id);
    }
}
