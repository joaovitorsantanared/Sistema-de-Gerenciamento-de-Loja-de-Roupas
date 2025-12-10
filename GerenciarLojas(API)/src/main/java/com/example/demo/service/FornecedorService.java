package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Fornecedor.FornecedorTecidos;
import com.example.demo.model.Fornecedor.FornecedorNacional;
import com.example.demo.model.Fornecedor.FornecedorInternacional;
import com.example.demo.model.Fornecedor.FornecedorAcessorio;

import com.example.demo.repository.FornecedorTecidosRepository;
import com.example.demo.repository.FornecedorNacionalRepository;
import com.example.demo.repository.FornecedorInternacionalRepository;
import com.example.demo.repository.FornecedorAcessorioRepository;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired 
    private FornecedorTecidosRepository fornecedorTecidosRepository;

    @Autowired 
    private FornecedorNacionalRepository fornecedorNacionalRepository;

    @Autowired 
    private FornecedorInternacionalRepository fornecedorInternacionalRepository;

    @Autowired 
    private FornecedorAcessorioRepository fornecedorAcessorioRepository;

    //Listar
    public List<FornecedorTecidos> getAllFornecedorTecidos() {
        return fornecedorTecidosRepository.findAll(); 
    }

    public List<FornecedorNacional> getAllFornecedorNacional() {
        return fornecedorNacionalRepository.findAll(); 
    }

    public List<FornecedorInternacional> getAllFornecedorInternacional() {
        return fornecedorInternacionalRepository.findAll(); 
    }

    public List<FornecedorAcessorio> getAllFornecedorAcessorio() {
        return fornecedorAcessorioRepository.findAll(); 
    }

    //Criar
    public FornecedorTecidos saveFornecedorTecidos(FornecedorTecidos fornecedorTecidos) {
        return fornecedorTecidosRepository.save(fornecedorTecidos); 
    }
    
    public FornecedorNacional saveFornecedorNacional(FornecedorNacional fornecedorNacional) {
        return fornecedorNacionalRepository.save(fornecedorNacional); 
    }

    public FornecedorInternacional saveFornecedorInternacional(FornecedorInternacional fornecedorInternacional) {
        return fornecedorInternacionalRepository.save(fornecedorInternacional); 
    }

    public FornecedorAcessorio saveFornecedorAcessorio(FornecedorAcessorio fornecedorAcessorio) {
        return fornecedorAcessorioRepository.save(fornecedorAcessorio); 
    }

    //Atualizar
    public FornecedorTecidos updateFornecedorTecidos(Long id, FornecedorTecidos atualizado) {
        return fornecedorTecidosRepository.findById(id)
            .map(f -> {
                f.setNome(atualizado.getNome());
                f.setEmail(atualizado.getEmail());
                f.setTelefone(atualizado.getTelefone());
                f.setTipoProdutoFornecido(atualizado.getTipoProdutoFornecido());
                return fornecedorTecidosRepository.save(f);
            })
            .orElseThrow(() -> new RuntimeException("Fornecedor de tecidos não encontrado"));
    }

    public FornecedorNacional updateFornecedorNacional(Long id, FornecedorNacional atualizado) {
        return fornecedorNacionalRepository.findById(id)
            .map(f -> {
                f.setNome(atualizado.getNome());
                f.setEmail(atualizado.getEmail());
                f.setTelefone(atualizado.getTelefone());
                f.setCnpj(atualizado.getCnpj());
                f.setTipoProdutoFornecido(atualizado.getTipoProdutoFornecido());
                return fornecedorNacionalRepository.save(f);
            })
            .orElseThrow(() -> new RuntimeException("Fornecedor nacional não encontrado"));
    }

    public FornecedorInternacional updateFornecedorInternacional(Long id, FornecedorInternacional atualizado) {
        return fornecedorInternacionalRepository.findById(id)
            .map(f -> {
                f.setNome(atualizado.getNome());
                f.setEmail(atualizado.getEmail());
                f.setTelefone(atualizado.getTelefone());
                f.setCnpj(atualizado.getCnpj());
                f.setEndereco(atualizado.getEndereco());
                f.setTipoProdutoFornecido(atualizado.getTipoProdutoFornecido());
                return fornecedorInternacionalRepository.save(f);
            })
            .orElseThrow(() -> new RuntimeException("Fornecedor internacional não encontrado"));
    }

    public FornecedorAcessorio updateFornecedorAcessorio(Long id, FornecedorAcessorio atualizado) {
        return fornecedorAcessorioRepository.findById(id)
            .map(f -> {
                f.setNome(atualizado.getNome());
                f.setEmail(atualizado.getEmail());
                f.setTelefone(atualizado.getTelefone());
                f.setTipoProdutoFornecido(atualizado.getTipoProdutoFornecido());
                return fornecedorAcessorioRepository.save(f);
            })
            .orElseThrow(() -> new RuntimeException("Fornecedor de acessórios não encontrado"));
    }

    //Deletar
    public void deleteFornecedorTecidos(Long id) {
        fornecedorTecidosRepository.deleteById(id); 
    }

    public void deleteFornecedorNacional(Long id) {
        fornecedorNacionalRepository.deleteById(id); 
    }

    public void deleteFornecedorInternacional(Long id) {
        fornecedorInternacionalRepository.deleteById(id); 
    }

    public void deleteFornecedorAcessorio(Long id) {
        fornecedorAcessorioRepository.deleteById(id); 
    }

    // Fornecedor Tecidos(Filha)
    public boolean verificarTecidoSustentavel(String tipoTecido) {
        return tipoTecido.equalsIgnoreCase("algodão orgânico") ||
               tipoTecido.equalsIgnoreCase("linho") ||
               tipoTecido.equalsIgnoreCase("bambu");
    }

    public double calcularCustoPorMetro(double valorLote, int metros) {
        if (metros <= 0) return 0;
        return valorLote / metros;
    }

    public String registrarLoteTecido(FornecedorTecidos fornecedor, String tipoTecido, int metrosRecebidos) {
        return "Lote registrado: " + metrosRecebidos + " metros de " + tipoTecido +
               " recebidos de " + fornecedor.getNome();
    }

    public String gerarEtiquetaOrigem(FornecedorTecidos fornecedor, String tipoTecido, String paisOrigem) {
        return "Tecido: " + tipoTecido + " | Fornecedor: " + fornecedor.getNome() + " | Origem: " + paisOrigem;
    }

    // Fornecedor Nacional(Filha)
    public boolean validarCNPJ(FornecedorNacional fornecedor) {
        return fornecedor.getCnpj() != null && fornecedor.getCnpj().length() == 18;
    }

    public double calcularImpostoNacional(double valorCompra) {
        double taxaImpostoNacional = 0.12; // 12%
        return valorCompra * taxaImpostoNacional;
    }

    public String gerarResumoFornecedorNacional(FornecedorNacional fornecedor) {
        return "Fornecedor Nacional: " + fornecedor.getNome() + "\n" +
               "CNPJ: " + fornecedor.getCnpj() + "\n" +
               "Contato: " + fornecedor.getEmail() + " / " + fornecedor.getTelefone() + "\n" +
               "Produtos: " + fornecedor.getTipoProdutoFornecido();
    }

    public String enviarPedidoNacional(FornecedorNacional fornecedor, String produto, int quantidade) {
        return "Pedido enviado para " + fornecedor.getNome() + ": " + quantidade + " unidades de " + produto;
    }

    // Fornecedor Internacional(Filha)
    public double calcularTaxaImportacao(double valorCompra) {
        double taxaImportacao = 0.25; // 25%
        return valorCompra * taxaImportacao;
    }

    public boolean exigeDocumentacaoExtra(String paisOrigem) {
        return !paisOrigem.equalsIgnoreCase("Brasil") &&
               !paisOrigem.equalsIgnoreCase("Argentina") &&
               !paisOrigem.equalsIgnoreCase("Paraguai") &&
               !paisOrigem.equalsIgnoreCase("Uruguai");
    }

    public String gerarResumoFornecedorInternacional(FornecedorInternacional fornecedor) {
        return "Fornecedor Internacional: " + fornecedor.getNome() + "\n" +
               "CNPJ: " + fornecedor.getCnpj() + "\n" +
               "Contato: " + fornecedor.getEmail() + " / " + fornecedor.getTelefone() + "\n" +
               "Endereço: " + fornecedor.getEndereco() + "\n" +
               "Produtos: " + fornecedor.getTipoProdutoFornecido();
    }

    public String enviarPedidoInternacional(FornecedorInternacional fornecedor, String produto, int quantidade, int diasEntrega) {
        return "Pedido internacional enviado para " + fornecedor.getNome() + ": " +
               quantidade + " unidades de " + produto + ". Prazo estimado: " + diasEntrega + " dias.";
    }

    // Fornecedor Acessorio(Filha)
    public boolean verificarMaterialReciclavel(String tipoMaterial) {
        return tipoMaterial.equalsIgnoreCase("plástico reciclado") ||
               tipoMaterial.equalsIgnoreCase("metal reaproveitado") ||
               tipoMaterial.equalsIgnoreCase("tecido reaproveitado");
    }

    public double calcularCustoPorUnidade(double valorLote, int quantidade) {
        if (quantidade <= 0) return 0;
        return valorLote / quantidade;
    }

    public String registrarLoteAcessorio(FornecedorAcessorio fornecedor, String tipoAcessorio, int quantidadeRecebida) {
        return "Lote registrado: " + quantidadeRecebida + " unidades de " + tipoAcessorio +
               " recebidas de " + fornecedor.getNome();
    }

    public String gerarEtiquetaAcessorio(FornecedorAcessorio fornecedor, String tipoAcessorio, String paisOrigem) {
        return "Acessório: " + tipoAcessorio + " | Fornecedor: " + fornecedor.getNome() + " | Origem: " + paisOrigem;
    }
}
