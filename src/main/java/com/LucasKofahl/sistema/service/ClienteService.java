package com.LucasKofahl.sistema.service;

import com.LucasKofahl.sistema.model.Cliente;
import com.LucasKofahl.sistema.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente salvar(Cliente cliente) {
        // Regra de negócio: Gerar a data de cadastro automaticamente se for novo (Etapa 10)
        if (cliente.getId() == null) {
            cliente.setDataCadastro(LocalDate.now()); // Automatiza a geração da data (Etapa 10)
        }

        // Regra de negócio: Validação simples de e-mail obrigatório
        if (cliente.getEmail() == null || cliente.getEmail().isEmpty()) {
            throw new RuntimeException("O e-mail do cliente é obrigatório!");
        }

        // Regra de negócio: Validação simples de CPF obrigatório (Etapa 5)
        if (cliente.getCpf() == null || cliente.getCpf().isEmpty()) {
            throw new RuntimeException("O CPF do cliente é obrigatório!");
        }

        return clienteRepository.save(cliente);
    }
}