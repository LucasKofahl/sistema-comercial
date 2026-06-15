package com.LucasKofahl.sistema.controller;

import com.LucasKofahl.sistema.model.Pedido;
import com.LucasKofahl.sistema.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> listar() {
        return pedidoService.listarTodos();
    }

    @PostMapping
    public Pedido cadastrar(@RequestBody Pedido pedido) {
        return pedidoService.salvar(pedido);
    }
}