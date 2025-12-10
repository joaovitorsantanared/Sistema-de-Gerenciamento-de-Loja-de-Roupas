package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Roupa.Acessorio;
import com.example.demo.model.Roupa.Calca;
import com.example.demo.model.Roupa.Camiseta;
import com.example.demo.model.Roupa.RoupaFeminina;
import com.example.demo.model.Roupa.RoupaMasculina;
import com.example.demo.model.Roupa.Vestido;

import com.example.demo.repository.AcessorioRepository;
import com.example.demo.repository.CalcaRepository;
import com.example.demo.repository.CamisetaRepository;
import com.example.demo.repository.RoupaFemininaRepository;
import com.example.demo.repository.RoupaMasculinaRepository;
import com.example.demo.repository.VestidoRepository;

import java.util.List;

@Service
public class RoupaService {
    
    @Autowired 
    private CalcaRepository calcaRepository;

    @Autowired 
    private AcessorioRepository acessorioRepository;

    @Autowired
    private CamisetaRepository camisetaRepository;

    @Autowired 
    private RoupaFemininaRepository roupaFemininaRepository;

    @Autowired 
    private RoupaMasculinaRepository roupaMasculinaRepository;

    @Autowired 
    private VestidoRepository vestidoRepository;

    //Listar
    public List<Calca> getAllCalca() {
        return calcaRepository.findAll(); 
    }

    public List<Acessorio> getAllAcessorio() {
        return acessorioRepository.findAll(); 
    }

    public List<Camiseta> getAllCamiseta() {
        return camisetaRepository.findAll(); 
    }

    public List<RoupaFeminina> getAllRoupaFeminina() {
        return roupaFemininaRepository.findAll(); 
    }

    public List<RoupaMasculina> getAllRoupaMasculina() {
        return roupaMasculinaRepository.findAll(); 
    }

    public List<Vestido> getAllVestido() {
        return vestidoRepository.findAll(); 
    }

    //Criar
    public Calca saveCalca(Calca calca) {
        return calcaRepository.save(calca); 
    }
    
    public Acessorio saveAcessorio(Acessorio acessorio) {
        return acessorioRepository.save(acessorio); 
    }

    public Camiseta saveCamiseta(Camiseta camiseta) {
        return camisetaRepository.save(camiseta); 
    }

    public RoupaFeminina saveRoupaFeminina(RoupaFeminina roupaFeminina) {
        return roupaFemininaRepository.save(roupaFeminina); 
    }

    public RoupaMasculina saveRoupaMasculina(RoupaMasculina roupaMasculina) {
        return roupaMasculinaRepository.save(roupaMasculina); 
    }

    public Vestido saveVestido(Vestido vestido) {
        return vestidoRepository.save(vestido); 
    }

    //Deletar 
    public void deleteCalca(Long id) {
        calcaRepository.deleteById(id); 
    }

    public void deleteAcessorio(Long id) {
        acessorioRepository.deleteById(id); 
    }

    public void deleteCamiseta(Long id) {
        camisetaRepository.deleteById(id); 
    }

    public void deleteRoupaFeminina(Long id) {
        roupaFemininaRepository.deleteById(id); 
    }

    public void deleteRoupaMasculina(Long id) {
        roupaMasculinaRepository.deleteById(id); 
    }

    public void deleteVestido(Long id) {
        vestidoRepository.deleteById(id); 
    }

    //Atualizar
    public Calca updateCalca(Long id, Calca calcaAtualizada) {
        return calcaRepository.findById(id)
            .map(c -> {
                c.setModeloCalca(calcaAtualizada.getModeloCalca());
                c.setPreco(calcaAtualizada.getPreco());
                c.setTamanho(calcaAtualizada.getTamanho());
                c.setCor(calcaAtualizada.getCor());
                c.setMarca(calcaAtualizada.getMarca());
                c.setQuantidadeEstoque(calcaAtualizada.getQuantidadeEstoque());
                return calcaRepository.save(c);
            })
            .orElseThrow(() -> new RuntimeException("Calça não encontrada"));
    }

    public Acessorio updateAcessorio(Long id, Acessorio acessorioAtualizado) {
        return acessorioRepository.findById(id)
            .map(a -> {
                a.setTipoAcessorio(acessorioAtualizado.getTipoAcessorio());
                a.setMaterial(acessorioAtualizado.getMaterial());
                a.setPreco(acessorioAtualizado.getPreco());
                a.setTamanho(acessorioAtualizado.getTamanho());
                a.setCor(acessorioAtualizado.getCor());
                a.setMarca(acessorioAtualizado.getMarca());
                a.setQuantidadeEstoque(acessorioAtualizado.getQuantidadeEstoque());
                return acessorioRepository.save(a);
            })
            .orElseThrow(() -> new RuntimeException("Acessório não encontrado"));
    }

    public Camiseta updateCamiseta(Long id, Camiseta camisetaAtualizada) {
        return camisetaRepository.findById(id)
            .map(c -> {
                c.setTipoGola(camisetaAtualizada.getTipoGola());
                c.setPreco(camisetaAtualizada.getPreco());
                c.setTamanho(camisetaAtualizada.getTamanho());
                c.setCor(camisetaAtualizada.getCor());
                c.setMarca(camisetaAtualizada.getMarca());
                c.setQuantidadeEstoque(camisetaAtualizada.getQuantidadeEstoque());
                return camisetaRepository.save(c);
            })
            .orElseThrow(() -> new RuntimeException("Camiseta não encontrada"));
    }

    public RoupaFeminina updateRoupaFeminina(Long id, RoupaFeminina roupaFemininaAtualizada) {
        return roupaFemininaRepository.findById(id)
            .map(r -> {
                r.setTipoPeca(roupaFemininaAtualizada.getTipoPeca());
                r.setTipoTecido(roupaFemininaAtualizada.getTipoTecido());
                r.setPreco(roupaFemininaAtualizada.getPreco());
                r.setTamanho(roupaFemininaAtualizada.getTamanho());
                r.setCor(roupaFemininaAtualizada.getCor());
                r.setMarca(roupaFemininaAtualizada.getMarca());
                r.setQuantidadeEstoque(roupaFemininaAtualizada.getQuantidadeEstoque());
                return roupaFemininaRepository.save(r);
            })
            .orElseThrow(() -> new RuntimeException("Roupa feminina não encontrada"));
    }

    public RoupaMasculina updateRoupaMasculina(Long id, RoupaMasculina roupaMasculinaAtualizada) {
        return roupaMasculinaRepository.findById(id)
            .map(r -> {
                r.setTipoPeca(roupaMasculinaAtualizada.getTipoPeca());
                r.setMaterial(roupaMasculinaAtualizada.getMaterial());
                r.setPreco(roupaMasculinaAtualizada.getPreco());
                r.setTamanho(roupaMasculinaAtualizada.getTamanho());
                r.setCor(roupaMasculinaAtualizada.getCor());
                r.setMarca(roupaMasculinaAtualizada.getMarca());
                r.setQuantidadeEstoque(roupaMasculinaAtualizada.getQuantidadeEstoque());
                return roupaMasculinaRepository.save(r);
            })
            .orElseThrow(() -> new RuntimeException("Roupa masculina não encontrada"));
    }

    public Vestido updateVestido(Long id, Vestido vestidoAtualizado) {
        return vestidoRepository.findById(id)
            .map(v -> {
                v.setComprimento(vestidoAtualizado.getComprimento());
                v.setPreco(vestidoAtualizado.getPreco());
                v.setTamanho(vestidoAtualizado.getTamanho());
                v.setCor(vestidoAtualizado.getCor());
                v.setMarca(vestidoAtualizado.getMarca());
                v.setQuantidadeEstoque(vestidoAtualizado.getQuantidadeEstoque());
                return vestidoRepository.save(v);
            })
            .orElseThrow(() -> new RuntimeException("Vestido não encontrado"));
    }
    public void deleteRoupaMaculina(long id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteRoupaMaculina'");
    }
}
