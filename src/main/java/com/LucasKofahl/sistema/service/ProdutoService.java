package com.LucasKofahl.sistema.service;

import com.LucasKofahl.sistema.model.Produto;
import com.LucasKofahl.sistema.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    // Listar todos os produtos
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    // Salvar ou atualizar produto com as regras de negócio
    public Produto salvar(Produto produto) {
        // Regra de negócio: Preço não pode ser negativo
        if (produto.getPreco() == null || produto.getPreco() < 0) {
            throw new RuntimeException("O preço do produto não pode ser negativo!");
        }

        // Regra de negócio: Estoque não pode ser negativo
        if (produto.getQuantidadeEstoque() == null || produto.getQuantidadeEstoque() < 0) {
            throw new RuntimeException("A quantidade em estoque não pode ser negativa!");
        }

        return produtoRepository.save(produto);
    }
}