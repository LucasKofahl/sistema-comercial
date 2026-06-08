package com.LucasKofahl.sistema.controller;

import com.LucasKofahl.sistema.model.Cliente;
import com.LucasKofahl.sistema.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listarTodos();
    }

    @PostMapping
    public Cliente cadastrar(@RequestBody Cliente cliente) {
        return clienteService.salvar(cliente);
    }
}