package com.LucasKofahl.sistema.repository;

import com.LucasKofahl.sistema.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // O JpaRepository já nos dá métodos como save(), findById(), findAll(), deleteById()
}