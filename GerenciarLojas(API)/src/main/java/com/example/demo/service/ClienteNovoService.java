package com.example.demo.service;

import com.example.demo.dtos.ClienteNovoRecordDto;
import com.example.demo.model.Cliente.ClienteNovo;
import com.example.demo.repository.ClienteNovoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteNovoService {

    @Autowired
    private ClienteNovoRepository clienteNovoRepository;

    // LISTAR TODOS
    public List<ClienteNovo> listarTodos() {
        return clienteNovoRepository.findAll();
    }

    // CADASTRAR
    public ClienteNovo cadastrar(ClienteNovoRecordDto dto) {
        if (clienteNovoRepository.existsByCpf(dto.cpf())) {
            throw new RuntimeException("CPF já cadastrado.");
        }

        ClienteNovo cliente = new ClienteNovo();
        BeanUtils.copyProperties(dto, cliente);

        return clienteNovoRepository.save(cliente);
    }

    //vai buscar o usuário pelo ID
    public ClienteNovo buscarId(Long id) {
        return clienteNovoRepository.findById(id).orElse(null);
    }

    // ATUALIZAR COMPLETO
    public ClienteNovo atualizarCliente(Long id, ClienteNovoRecordDto dto) {
        ClienteNovo existente = buscarId(id);
        if (existente == null) return null;

        //vai impedir a alteração do CPF
        if (!existente.getCpf().equals(dto.cpf())) {
            throw new RuntimeException("O CPF não pode ser alterado.");
        }

        //vai atualizar os campos permitidos
        existente.setNome(dto.nome());
        existente.setEmail(dto.email());
        existente.setNumero(dto.numero());
        existente.setPontuacaoInicial(dto.pontuacaoInicial());
        existente.setPrimeiraCompra(dto.primeiraCompra());

        return clienteNovoRepository.save(existente);
    }

    //irá atualizar a pontuação
    public ClienteNovo atualizarPontuacao(Long id, int pontos) {
        ClienteNovo cliente = buscarId(id);
        if (cliente == null) return null;

        cliente.setPontuacaoInicial(cliente.getPontuacaoInicial() + pontos);
        return clienteNovoRepository.save(cliente);
    }

    //vai atualizar caso tenha feito a primeira compra
    public ClienteNovo marcarPrimeiraCompra(Long id, boolean primeiraCompra) {
        ClienteNovo cliente = buscarId(id);
        if (cliente == null) return null;

        cliente.setPrimeiraCompra(primeiraCompra);
        return clienteNovoRepository.save(cliente);
    }

    // DELETAR POR ID
    public boolean deletarPorId(Long id) {
        ClienteNovo cliente = buscarId(id);
        if (cliente == null) return false;

        clienteNovoRepository.delete(cliente);
        return true;
    }
}

