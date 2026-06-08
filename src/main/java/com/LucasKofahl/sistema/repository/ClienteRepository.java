package com.LucasKofahl.sistema.repository;

import com.LucasKofahl.sistema.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Aqui você já ganha os métodos automáticos de CRUD para o Cliente!
}
