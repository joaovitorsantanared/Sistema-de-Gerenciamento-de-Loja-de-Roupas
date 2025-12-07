package com.example.demo.controller;

import com.example.demo.model.empresa.Empresa;
import com.example.demo.model.funcionario.Gerente;
import com.example.demo.service.GerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/gerentes")
public class GerenteController {

    @Autowired
    private GerenteService gerenteService;

    @GetMapping
    public List<Gerente> getAll() {
        return gerenteService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Gerente> getById(@PathVariable Long id) {
        return gerenteService.getById(id);
    }

    @PostMapping
    public Gerente createGerente(@RequestBody Gerente gerente) {
        return gerenteService.save(gerente);
    }

    @PutMapping("/{id}")
    public Gerente update(@PathVariable Long id, @RequestBody Gerente gerenteAtualizado) {
        return gerenteService.update(id, gerenteAtualizado);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        gerenteService.delete(id);
    }
}
