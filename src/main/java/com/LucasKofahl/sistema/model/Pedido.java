package com.LucasKofahl.sistema.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataPedido;

    @Column(nullable = false)
    private Double valorTotal;

    @Column(nullable = false)
    private String status; // Ex: "PENDENTE", "PAGO", "CANCELADO"

    public Pedido() {

    }

    // --- GETTERS E SETTERS ---
    public Long getId() {
      return id;
    }
    public void setId(Long id) {
      this.id = id;
    }

    public LocalDate getDataPedido() {
      return dataPedido;
    }
    public void setDataPedido(LocalDate dataPedido) {
      this.dataPedido = dataPedido;
    }

    public Double getValorTotal() {
      return valorTotal;
    }
    public void setValorTotal(Double valorTotal) {
      this.valorTotal = valorTotal;
    }

    public String getStatus() {
      return status;
    }
    public void setStatus(String status) {
      this.status = status;
    }
}