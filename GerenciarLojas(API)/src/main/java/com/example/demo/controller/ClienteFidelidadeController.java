package com.example.demo.controller;

import com.example.demo.dtos.ClienteFidelidadeRecordDto;
import com.example.demo.model.Cliente.ClienteFidelidade;
import com.example.demo.service.ClienteFidelidadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientefidelidade")
public class ClienteFidelidadeController {

    @Autowired
    private ClienteFidelidadeService service;

    @GetMapping("/lista")
    public ResponseEntity<List<ClienteFidelidade>> listarTodos() {
        List<ClienteFidelidade> clientes = service.listarTodos();
        if (clientes.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(clientes);
    }

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastrar(@RequestBody @Valid ClienteFidelidadeRecordDto dto) {
        try {
            ClienteFidelidade cliente = service.cadastrar(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        ClienteFidelidade cliente = service.buscarPorId(id);
        if (cliente == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody @Valid ClienteFidelidadeRecordDto dto) {
        ClienteFidelidade atualizado = service.atualizar(id, dto);
        if (atualizado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(atualizado);
    }

    @PatchMapping("/{id}/pontuacao")
    public ResponseEntity<?> atualizarPontuacao(@PathVariable Long id, @RequestParam int pontos) {
        ClienteFidelidade atualizado = service.atualizarPontuacao(id, pontos);
        if (atualizado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(atualizado);
    }

    @PatchMapping("/{id}/nivel")
    public ResponseEntity<?> atualizarNivel(@PathVariable Long id, @RequestParam int nivel) {
        try {
            ClienteFidelidade atualizado = service.atualizarNivel(id, nivel);
            if (atualizado == null) return ResponseEntity.notFound().build();
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PatchMapping("/{id}/zerar")
    public ResponseEntity<?> zerarPontuacao(@PathVariable Long id) {
        ClienteFidelidade atualizado = service.zerarPontuacao(id);
        if (atualizado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        boolean deletado = service.deletar(id);
        if (!deletado) return ResponseEntity.notFound().build();
        return ResponseEntity.ok("Cliente removido com sucesso.");
    }
}
