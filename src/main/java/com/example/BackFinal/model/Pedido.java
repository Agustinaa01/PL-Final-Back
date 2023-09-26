package com.example.BackFinal.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private int quantity;
    private Date date;
    private double total;
    private String state;

    public Pedido(Integer id, int quantity, Date date, double total, String state, AppUser usuario, List<Producto> productos) {
        this.id = id;
        this.quantity = quantity;
        this.date = date;
        this.total = total;
        this.state = state;
        this.usuario = usuario;
        this.productos = productos;
    }

    @ManyToOne //relacion usuario/pedido
    @JoinColumn(name = "usuario_id")
    private AppUser usuario;
    @OneToMany(mappedBy = "pedido") //relacion pedido/producto
    private List<Producto> productos;
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Pedido() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
