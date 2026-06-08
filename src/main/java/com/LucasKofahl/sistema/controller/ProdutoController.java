package com.LucasKofahl.sistema.controller;

import com.LucasKofahl.sistema.model.Produto;
import com.LucasKofahl.sistema.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin(origins = "*") // Permite que seu JavaScript acesse a API sem erros de CORS
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    // Rota para LISTAR todos os produtos
    // URL: http://localhost:8090/api/produtos
    @GetMapping
    public List<Produto> listar() {
        return produtoService.listarTodos();
    }

    // Rota para CADASTRAR um novo produto
    // URL: http://localhost:8090/api/produtos
    @PostMapping
    public Produto cadastrar(@RequestBody Produto produto) {
        return produtoService.salvar(produto);
    }
}