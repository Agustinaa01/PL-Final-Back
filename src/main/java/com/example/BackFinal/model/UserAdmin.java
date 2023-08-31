package com.example.BackFinal.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@DiscriminatorValue("admin")
public class UserAdmin extends User{

    public UserAdmin(Integer id, String nombre, String email) {
        super(id, nombre, email);
    }
    @OneToMany(mappedBy = "administrador")
    private List<Producto> productosAdmin;

    public UserAdmin() {

    }
}
