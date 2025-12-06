package com.example.demo.controller;

import com.example.demo.model.funcionario.Vendedor;
import com.example.demo.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    @GetMapping
    public List<Vendedor> getAll() {
        return vendedorService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Vendedor> getById(@PathVariable Long id) {
        return vendedorService.getById(id);
    }

    @PostMapping
    public Vendedor create(@RequestBody Vendedor vendedor) {
        return vendedorService.save(vendedor);
    }

    @PutMapping("/{id}")
    public Vendedor update(@PathVariable Long id, @RequestBody Vendedor vendedorAtualizado) {
        return vendedorService.update(id, vendedorAtualizado);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        vendedorService.delete(id);
    }

    @PostMapping("/{id}/registrar-venda")
    public Vendedor registrarVenda(@PathVariable Long id, @RequestParam double valor) {
        return vendedorService.registrarVenda(id, valor);
    }
}
