package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Roupa.Acessorio;
import com.example.demo.model.Roupa.Calca;
import com.example.demo.model.Roupa.Camiseta;
import com.example.demo.model.Roupa.RoupaFeminina;
import com.example.demo.model.Roupa.RoupaMasculina;
import com.example.demo.model.Roupa.Vestido;
import com.example.demo.service.RoupaService;

@RestController
@RequestMapping("/roupa")
public class RoupaController {
    @Autowired
    private RoupaService roupaService;

    //Listar
    @GetMapping("/calca")
    public List<Calca> getAllCalca(){
        return roupaService.getAllCalca(); 
    }

    @GetMapping("/acessorio")
    public List<Acessorio> getAllAcessorio(){
        return roupaService.getAllAcessorio(); 
    }

    @GetMapping("/camiseta")
    public List<Camiseta> getAllCamiseta(){
        return roupaService.getAllCamiseta();
    }

    @GetMapping("/roupafeminina")
    public List<RoupaFeminina> getAllRoupaFeminina(){
        return roupaService.getAllRoupaFeminina(); 
    }

    @GetMapping("/roupamasculina")
    public List<RoupaMasculina> getAllRoupaMasculina(){
        return roupaService.getAllRoupaMasculina(); 
    }

    @GetMapping("/vestido")
    public List<Vestido> getAllVestido(){
        return roupaService.getAllVestido(); 
    }

    //Criar
    @PostMapping("/calca")
    public Calca createCalca (@RequestBody Calca calca){
        return roupaService.saveCalca(calca); 
    }

    @PostMapping("/acessorio")
    public Acessorio createAcessorio (@RequestBody Acessorio acessorio){
        return roupaService.saveAcessorio(acessorio); 
    }

    @PostMapping("/camiseta")
    public Camiseta createCamiseta (@RequestBody Camiseta camiseta){
        return roupaService.saveCamiseta(camiseta); 
    }

    @PostMapping("/roupafeminina")
    public RoupaFeminina createRoupaFeminina (@RequestBody RoupaFeminina roupaFeminina){
        return roupaService.saveRoupaFeminina(roupaFeminina); 
    }

    @PostMapping("/roupamasculina")
    public RoupaMasculina createRoupaMasculina (@RequestBody RoupaMasculina roupaMasculina){
        return roupaService.saveRoupaMasculina(roupaMasculina); 
    }

    @PostMapping("/vestido")
    public Vestido createVestido (@RequestBody Vestido vestido){
        return roupaService.saveVestido(vestido); 
    }

    //Deletar
    @DeleteMapping("/calca/{id}")
    public void deleteCalca(@PathVariable Long id){
        roupaService.deleteCalca(id); 
    }

    @DeleteMapping("/acessorio/{id}")
    public void deleteAcessorio(@PathVariable Long id){
        roupaService.deleteAcessorio(id); 
    }

    @DeleteMapping("/camiseta/{id}")
    public void deleteCamiseta(@PathVariable Long id){
        roupaService.deleteCamiseta(id); 
    }

    @DeleteMapping("/roupafeminina/{id}")
    public void deleteRoupaFeminina(@PathVariable Long id){
        roupaService.deleteRoupaFeminina(id); 
    }

    @DeleteMapping("/roupamasculina/{id}")
    public void deleteRoupaMasculina(@PathVariable Long id){
        roupaService.deleteRoupaMasculina(id); 
    }

    @DeleteMapping("/vestido/{id}")
    public void deleteVestido(@PathVariable Long id){
        roupaService.deleteVestido(id); 
    }

    //Atualizar
    @PutMapping("/calca/{id}")
    public Calca updateCalca(@PathVariable Long id, @RequestBody Calca calcaAtualizado) {
        return roupaService.updateCalca(id, calcaAtualizado);
    }

    @PutMapping("/acessorio/{id}")
    public Acessorio updateAcessorio(@PathVariable Long id, @RequestBody Acessorio acessorioAtualizado) {
        return roupaService.updateAcessorio(id, acessorioAtualizado);
    }

    @PutMapping("/camiseta/{id}")
    public Camiseta updateCamiseta(@PathVariable Long id, @RequestBody Camiseta camisetaAtualizada) {
        return roupaService.updateCamiseta(id, camisetaAtualizada);
    }

    @PutMapping("/roupafeminina/{id}")
    public RoupaFeminina updateRoupaFeminina(@PathVariable Long id, @RequestBody RoupaFeminina roupaFemininaAtualizada) {
        return roupaService.updateRoupaFeminina(id, roupaFemininaAtualizada);
    }

    @PutMapping("/roupamasculina/{id}")
    public RoupaMasculina updateRoupaMasculina(@PathVariable Long id, @RequestBody RoupaMasculina roupaMasculinaAtualizada) {
        return roupaService.updateRoupaMasculina(id, roupaMasculinaAtualizada);
    }

    @PutMapping("/vestido/{id}")
    public Vestido updateVestido(@PathVariable Long id, @RequestBody Vestido vestidoAtualizado) {
        return roupaService.updateVestido(id, vestidoAtualizado);
    }
}
