package com.LucasKofahl.sistema.service;

import com.LucasKofahl.sistema.model.Pedido;
import com.LucasKofahl.sistema.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Pedido salvar(Pedido pedido) {
        // Preenche a data automaticamente se for um pedido novo
        if (pedido.getId() == null) {
            pedido.setDataPedido(LocalDate.now());
        }

        // Validação básica
        if (pedido.getValorTotal() == null || pedido.getValorTotal() <= 0) {
            throw new RuntimeException("O valor total do pedido deve ser maior que zero!");
        }
        
        if (pedido.getStatus() == null || pedido.getStatus().isEmpty()) {
            pedido.setStatus("PENDENTE"); // Status padrão
        }

        return pedidoRepository.save(pedido);
    }
}