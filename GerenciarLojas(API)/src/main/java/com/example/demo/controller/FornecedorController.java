package com.example.demo.controller;

import com.example.demo.model.Fornecedor.FornecedorTecidos;
import com.example.demo.model.Fornecedor.FornecedorNacional;
import com.example.demo.model.Fornecedor.FornecedorInternacional;
import com.example.demo.model.Fornecedor.FornecedorAcessorio;
import com.example.demo.service.FornecedorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    //Listar
    @GetMapping("/fornecedortecidos")
    public List<FornecedorTecidos> getAllFornecedorTecidos() {
        return fornecedorService.getAllFornecedorTecidos();
    }

    @GetMapping("/fornecedornacional")
    public List<FornecedorNacional> getAllFornecedorNacional() {
        return fornecedorService.getAllFornecedorNacional();
    }

    @GetMapping("/fornecedorinternacional")
    public List<FornecedorInternacional> getAllFornecedorInternacional() {
        return fornecedorService.getAllFornecedorInternacional();
    }

    @GetMapping("/fornecedoracessorio")
    public List<FornecedorAcessorio> getAllFornecedorAcessorio() {
        return fornecedorService.getAllFornecedorAcessorio();
    }

    //Criar
    @PostMapping("/fornecedortecidos")
    public FornecedorTecidos createFornecedorTecidos(@RequestBody FornecedorTecidos fornecedorTecidos) {
        return fornecedorService.saveFornecedorTecidos(fornecedorTecidos);
    }

    @PostMapping("/fornecedornacional")
    public FornecedorNacional createFornecedorNacional(@RequestBody FornecedorNacional fornecedorNacional) {
        return fornecedorService.saveFornecedorNacional(fornecedorNacional);
    }

    @PostMapping("/fornecedorinternacional")
    public FornecedorInternacional createFornecedorInternacional(@RequestBody FornecedorInternacional fornecedorInternacional) {
        return fornecedorService.saveFornecedorInternacional(fornecedorInternacional);
    }

    @PostMapping("/fornecedoracessorio")
    public FornecedorAcessorio createFornecedorAcessorio(@RequestBody FornecedorAcessorio fornecedorAcessorio) {
        return fornecedorService.saveFornecedorAcessorio(fornecedorAcessorio);
    }

    //Atualizar
    @PutMapping("/fornecedortecidos/{id}")
    public FornecedorTecidos updateFornecedorTecidos(@PathVariable Long id, @RequestBody FornecedorTecidos atualizado) {
        return fornecedorService.updateFornecedorTecidos(id, atualizado);
    }

    @PutMapping("/fornecedornacional/{id}")
    public FornecedorNacional updateFornecedorNacional(@PathVariable Long id, @RequestBody FornecedorNacional atualizado) {
        return fornecedorService.updateFornecedorNacional(id, atualizado);
    }

    @PutMapping("/fornecedorinternacional/{id}")
    public FornecedorInternacional updateFornecedorInternacional(@PathVariable Long id, @RequestBody FornecedorInternacional atualizado) {
        return fornecedorService.updateFornecedorInternacional(id, atualizado);
    }

    @PutMapping("/fornecedoracessorio/{id}")
    public FornecedorAcessorio updateFornecedorAcessorio(@PathVariable Long id, @RequestBody FornecedorAcessorio atualizado) {
        return fornecedorService.updateFornecedorAcessorio(id, atualizado);
    }

    //Deletar
    @DeleteMapping("/fornecedortecidos/{id}")
    public void deleteFornecedorTecidos(@PathVariable Long id) {
        fornecedorService.deleteFornecedorTecidos(id);
    }

    @DeleteMapping("/fornecedornacional/{id}")
    public void deleteFornecedorNacional(@PathVariable Long id) {
        fornecedorService.deleteFornecedorNacional(id);
    }

    @DeleteMapping("/fornecedorinternacional/{id}")
    public void deleteFornecedorInternacional(@PathVariable Long id) {
        fornecedorService.deleteFornecedorInternacional(id);
    }

    @DeleteMapping("/fornecedoracessorio/{id}")
    public void deleteFornecedorAcessorio(@PathVariable Long id) {
        fornecedorService.deleteFornecedorAcessorio(id);
    }

    //Fornecedor Tecidos (Filha)
    @GetMapping("/fornecedortecidos/verificar-sustentavel")
    public boolean verificarTecidoSustentavel(@RequestParam String tipoTecido) {
        return fornecedorService.verificarTecidoSustentavel(tipoTecido);
    }

    @GetMapping("/fornecedortecidos/custo-metro")
    public double calcularCustoPorMetro(@RequestParam double valorLote, @RequestParam int metros) {
        return fornecedorService.calcularCustoPorMetro(valorLote, metros);
    }

    @PostMapping("/fornecedortecidos/{id}/registrar-lote")
    public String registrarLoteTecido(@PathVariable Long id,
                                      @RequestParam String tipoTecido,
                                      @RequestParam int metrosRecebidos) {
        FornecedorTecidos fornecedor = fornecedorService.getAllFornecedorTecidos()
                .stream().filter(f -> f.getId().equals(id)).findFirst()
                .orElseThrow(() -> new RuntimeException("Fornecedor de tecidos não encontrado"));
        return fornecedorService.registrarLoteTecido(fornecedor, tipoTecido, metrosRecebidos);
    }

    @GetMapping("/fornecedortecidos/{id}/etiqueta")
    public String gerarEtiquetaOrigem(@PathVariable Long id,
                                      @RequestParam String tipoTecido,
                                      @RequestParam String paisOrigem) {
        FornecedorTecidos fornecedor = fornecedorService.getAllFornecedorTecidos()
                .stream().filter(f -> f.getId().equals(id)).findFirst()
                .orElseThrow(() -> new RuntimeException("Fornecedor de tecidos não encontrado"));
        return fornecedorService.gerarEtiquetaOrigem(fornecedor, tipoTecido, paisOrigem);
    }

    //Fornecedor Nacional (Filha)
    @GetMapping("/fornecedornacional/{id}/validar-cnpj")
    public boolean validarCNPJ(@PathVariable Long id) {
        FornecedorNacional fornecedor = fornecedorService.getAllFornecedorNacional()
                .stream().filter(f -> f.getId().equals(id)).findFirst()
                .orElseThrow(() -> new RuntimeException("Fornecedor nacional não encontrado"));
        return fornecedorService.validarCNPJ(fornecedor);
    }

    @GetMapping("/fornecedornacional/imposto")
    public double calcularImpostoNacional(@RequestParam double valorCompra) {
        return fornecedorService.calcularImpostoNacional(valorCompra);
    }

    @GetMapping("/fornecedornacional/{id}/resumo")
    public String gerarResumoFornecedorNacional(@PathVariable Long id) {
        FornecedorNacional fornecedor = fornecedorService.getAllFornecedorNacional()
                .stream().filter(f -> f.getId().equals(id)).findFirst()
                .orElseThrow(() -> new RuntimeException("Fornecedor nacional não encontrado"));
        return fornecedorService.gerarResumoFornecedorNacional(fornecedor);
    }

    @PostMapping("/fornecedornacional/{id}/enviar-pedido")
    public String enviarPedidoNacional(@PathVariable Long id,
                                       @RequestParam String produto,
                                       @RequestParam int quantidade) {
        FornecedorNacional fornecedor = fornecedorService.getAllFornecedorNacional()
                .stream().filter(f -> f.getId().equals(id)).findFirst()
                .orElseThrow(() -> new RuntimeException("Fornecedor nacional não encontrado"));
        return fornecedorService.enviarPedidoNacional(fornecedor, produto, quantidade);
    }

    //Fornecedor Internacional (Filha)
    @GetMapping("/fornecedorinternacional/taxa-importacao")
    public double calcularTaxaImportacao(@RequestParam double valorCompra) {
        return fornecedorService.calcularTaxaImportacao(valorCompra);
    }

    @GetMapping("/fornecedorinternacional/documentacao-extra")
    public boolean exigeDocumentacaoExtra(@RequestParam String paisOrigem) {
        return fornecedorService.exigeDocumentacaoExtra(paisOrigem);
    }

    @GetMapping("/fornecedorinternacional/{id}/resumo")
    public String gerarResumoFornecedorInternacional(@PathVariable Long id) {
        FornecedorInternacional fornecedor = fornecedorService.getAllFornecedorInternacional()
                .stream().filter(f -> f.getId().equals(id)).findFirst()
                .orElseThrow(() -> new RuntimeException("Fornecedor internacional não encontrado"));
        return fornecedorService.gerarResumoFornecedorInternacional(fornecedor);
    }

    @PostMapping("/fornecedorinternacional/{id}/enviar-pedido")
    public String enviarPedidoInternacional(@PathVariable Long id,
                                            @RequestParam String produto,
                                            @RequestParam int quantidade,
                                            @RequestParam int diasEntrega) {
        FornecedorInternacional fornecedor = fornecedorService.getAllFornecedorInternacional()
                .stream().filter(f -> f.getId().equals(id)).findFirst()
                .orElseThrow(() -> new RuntimeException("Fornecedor internacional não encontrado"));
        return fornecedorService.enviarPedidoInternacional(fornecedor, produto, quantidade, diasEntrega);
    }

    //Fornecedor acessorio (Filha)
    @GetMapping("/fornecedoracessorio/verificar-reciclavel")
    public boolean verificarMaterialReciclavel(@RequestParam String tipoMaterial) {
        return fornecedorService.verificarMaterialReciclavel(tipoMaterial);
    }

    @GetMapping("/fornecedoracessorio/custo-unidade")
    public double calcularCustoPorUnidade(@RequestParam double valorLote, @RequestParam int quantidade) {
        return fornecedorService.calcularCustoPorUnidade(valorLote, quantidade);
    }
}