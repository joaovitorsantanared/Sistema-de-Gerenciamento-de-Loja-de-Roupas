package com.example.demo.controller;

import com.example.demo.dtos.ClienteNovoRecordDto;
import com.example.demo.model.Cliente.ClienteNovo;
import com.example.demo.service.ClienteNovoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientenovo")
public class ClienteNovoController {

    @Autowired
    private ClienteNovoService clienteNovoService;

    // LISTAR TODOS
    @GetMapping("/lista")
    public ResponseEntity<List<ClienteNovo>> listarClientesNovos() {
        List<ClienteNovo> clientes = clienteNovoService.listarTodos();

        // Se não houver clientes, retorna HTTP 204 (No Content)
        if (clientes.isEmpty()) return ResponseEntity.noContent().build();

        // Caso existam clientes, retorna HTTP 200 (OK) com a lista
        return ResponseEntity.ok(clientes);
    }

    // CRIAR UM NOVO CLIENTE
    @PostMapping("/cadastro")
    public ResponseEntity<?> criarClienteNovo(@RequestBody @Valid ClienteNovoRecordDto dto) {
        try {
            ClienteNovo clienteCriado = clienteNovoService.cadastrar(dto);

            // Retorna HTTP 201 (Created) com o cliente criado
            return ResponseEntity.status(HttpStatus.CREATED).body(clienteCriado);
        } catch (RuntimeException e) {
            // Caso CPF já exista, retorna HTTP 409 (Conflict) com a mensagem de erro
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    // BUSCAR CLIENTE POR ID
    // Exemplo de URL: /clientenovo/1
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        ClienteNovo cliente = clienteNovoService.buscarId(id);

        // Se não encontrar cliente, retorna HTTP 404 (Not Found)
        if (cliente == null) return ResponseEntity.notFound().build();

        // Se encontrar, retorna HTTP 200 (OK) com o cliente
        return ResponseEntity.ok(cliente);
    }

    // ATUALIZAR COMPLETAMENTE UM CLIENTE POR ID
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarCliente(
            @PathVariable Long id,
            @RequestBody @Valid ClienteNovoRecordDto dto) {

        ClienteNovo atualizado = clienteNovoService.atualizarCliente(id, dto);

        // Se não encontrar cliente, retorna HTTP 404 (Not Found)
        if (atualizado == null) return ResponseEntity.notFound().build();

        // Se atualizar, retorna HTTP 200 (OK) com o cliente atualizado
        return ResponseEntity.ok(atualizado);
    }

    // ATUALIZAR SOMENTE A PONTUAÇÃO DE UM CLIENTE
    // Exemplo de URL: /clientenovo/1/pontuacao?pontos=50
    @PatchMapping("/{id}/pontuacao")
    public ResponseEntity<?> atualizarPontuacao(
            @PathVariable Long id,
            @RequestParam int pontos) {

        ClienteNovo atualizado = clienteNovoService.atualizarPontuacao(id, pontos);

        // Se não encontrar cliente, retorna HTTP 404 (Not Found)
        if (atualizado == null) return ResponseEntity.notFound().build();

        // Se atualizar, retorna HTTP 200 (OK) com o cliente atualizado
        return ResponseEntity.ok(atualizado);
    }

    // ATUALIZAR STATUS DE PRIMEIRA COMPRA
    // Exemplo de URL: /clientenovo/1/primeira-compra?primeiraCompra=true
    @PatchMapping("/{id}/primeira-compra")
    public ResponseEntity<?> marcarPrimeiraCompra(
            @PathVariable Long id,
            @RequestParam boolean primeiraCompra) {

        ClienteNovo atualizado = clienteNovoService.marcarPrimeiraCompra(id, primeiraCompra);

        // Se não encontrar cliente, retorna HTTP 404 (Not Found)
        if (atualizado == null) return ResponseEntity.notFound().build();

        // Se atualizar, retorna HTTP 200 (OK) com o cliente atualizado
        return ResponseEntity.ok(atualizado);
    }

    // DELETAR CLIENTE POR ID
    // Exemplo de URL: /clientenovo/1
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        boolean deletado = clienteNovoService.deletarPorId(id);

        // Se não encontrar cliente, retorna HTTP 404 (Not Found)
        if (!deletado) return ResponseEntity.notFound().build();

        // Se deletar, retorna HTTP 200 (OK) com mensagem de sucesso
        return ResponseEntity.ok("Cliente removido com sucesso.");
    }


}
