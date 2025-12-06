package com.example.demo.service;

import com.example.demo.dtos.ClienteFidelidadeRecordDto;
import com.example.demo.model.Cliente.ClienteFidelidade;
import com.example.demo.repository.ClienteFidelidadeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteFidelidadeService {

    @Autowired
    private ClienteFidelidadeRepository repository;

    // LISTAR TODOS
    public List<ClienteFidelidade> listarTodos() {
        return repository.findAll();
    }

    // BUSCAR POR ID
    public ClienteFidelidade buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    // CADASTRAR CLIENTE
    public ClienteFidelidade cadastrar(ClienteFidelidadeRecordDto dto) {
        if (repository.existsByCpf(dto.cpf())) {
            throw new RuntimeException("CPF já cadastrado.");
        }
        ClienteFidelidade cliente = new ClienteFidelidade();
        BeanUtils.copyProperties(dto, cliente);
        return repository.save(cliente);
    }

    // ATUALIZAR CLIENTE
    public ClienteFidelidade atualizar(Long id, ClienteFidelidadeRecordDto dto) {
        ClienteFidelidade existente = buscarPorId(id);
        if (existente == null) return null;
        if (!existente.getCpf().equals(dto.cpf())) {
            throw new RuntimeException("O CPF não pode ser alterado.");
        }
        existente.setNome(dto.nome());
        existente.setEmail(dto.email());
        existente.setNumero(dto.numero());
        existente.setPontosFidelidade(dto.pontosFidelidade());
        existente.setNivelFidelidade(dto.nivelFidelidade());
        return repository.save(existente);
    }

    // ATUALIZAR PONTUAÇÃO
    public ClienteFidelidade atualizarPontuacao(Long id, int pontos) {
        ClienteFidelidade cliente = buscarPorId(id);
        if (cliente == null) return null;
        int novaPontuacao = cliente.getPontosFidelidade() + pontos;
        if (novaPontuacao < 0) novaPontuacao = 0;
        cliente.setPontosFidelidade(novaPontuacao);
        return repository.save(cliente);
    }

    // ATUALIZAR NÍVEL
    public ClienteFidelidade atualizarNivel(Long id, int nivel) {
        ClienteFidelidade cliente = buscarPorId(id);
        if (cliente == null) return null;
        if (nivel < 0 || nivel > 3) {
            throw new RuntimeException("Nível deve ser entre 0 e 3.");
        }
        cliente.setNivelFidelidade(nivel);
        return repository.save(cliente);
    }

    // ZERAR PONTUAÇÃO
    public ClienteFidelidade zerarPontuacao(Long id) {
        ClienteFidelidade cliente = buscarPorId(id);
        if (cliente == null) return null;
        cliente.setPontosFidelidade(0);
        return repository.save(cliente);
    }

    // DELETAR CLIENTE
    public boolean deletar(Long id) {
        ClienteFidelidade cliente = buscarPorId(id);
        if (cliente == null) return false;
        repository.delete(cliente);
        return true;
    }
}
