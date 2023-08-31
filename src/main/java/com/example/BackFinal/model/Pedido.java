package com.example.BackFinal.model;

import jakarta.persistence.*;
import java.util.Date;


@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private Date fechaPedido;
    private double total;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private UserCliente cliente;
    public Pedido(Integer id, Date fechaPedido, double total) {
        this.id = id;
        this.fechaPedido = fechaPedido;
        this.total = total;
    }

    public Pedido() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
