package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Venda.VendasOnline;
import com.example.demo.model.Venda.VendasPresencial;
import com.example.demo.service.VendasService;

@RestController
@RequestMapping("/vendas")
public class VendasController {

    @Autowired
    private VendasService vendasService;

    //Listar
    @GetMapping("/online")
    public List<VendasOnline> getAllVendasOnline() {
        return vendasService.getAllVendasOnline();
    }

    @GetMapping("/presenciais")
    public List<VendasPresencial> getAllVendasPresenciais() {
        return vendasService.getAllVendasPresenciais();
    }

    //Criar
    @PostMapping("/online")
    public VendasOnline saveVendasOnline(@RequestBody VendasOnline vendasOnline) {
        return vendasService.saveVendasOnline(vendasOnline);
    }

    @PostMapping("/presenciais")
    public VendasPresencial saveVendasPresencial(@RequestBody VendasPresencial vendasPresencial) {
        return vendasService.saveVendasPresencial(vendasPresencial);
    }

    //Atualizar
    @PutMapping("/online/{id}")
    public VendasOnline updateVendasOnline(@PathVariable Long id, @RequestBody VendasOnline vendaOnlineAtualizada) {
        return vendasService.updateVendasOnline(id, vendaOnlineAtualizada);
    }

    @PutMapping("/presenciais/{id}")
    public VendasPresencial updateVendasPresencial(@PathVariable Long id, @RequestBody VendasPresencial vendaPresencialAtualizada) {
        return vendasService.updateVendasPresencial(id, vendaPresencialAtualizada);
    }

    //Deletar
    @DeleteMapping("/online/{id}")
    public void deleteVendasOnline(@PathVariable Long id) {
        vendasService.deleteVendasOnline(id);
    }

    @DeleteMapping("/presenciais/{id}")
    public void deleteVendasPresenciais(@PathVariable Long id) {
        vendasService.deleteVendasPresenciais(id);
    }

    @GetMapping("/online/info/{id}")
    public String exibirInformacoesOnline(@PathVariable Long id) {
        VendasOnline vendaOnline = vendasService.getAllVendasOnline()
                .stream()
                .filter(v -> v.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Venda online não encontrada"));

        return vendasService.exibirInformacoesOnline(vendaOnline);
    }

    @GetMapping("/presenciais/info/{id}")
    public String exibirInformacoesPresencial(@PathVariable Long id) {
        VendasPresencial vendaPresencial = vendasService.getAllVendasPresenciais()
                .stream()
                .filter(v -> v.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Venda presencial não encontrada"));

        return vendasService.exibirInformacoesPresencial(vendaPresencial);
    }
}
