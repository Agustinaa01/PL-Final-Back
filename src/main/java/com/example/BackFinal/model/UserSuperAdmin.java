package com.example.BackFinal.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@DiscriminatorValue("superAdmin")
public class UserSuperAdmin extends User{
    public UserSuperAdmin(Integer id, String nombre, String email) {
        super(id, nombre, email);
    }

    public UserSuperAdmin() {

    }
    @OneToMany(mappedBy = "superadministrador")
    private List<Producto> productosAdmin;

    @OneToMany(mappedBy = "superadministrador")
    private List<Pedido> pedidosAdmin;

}
