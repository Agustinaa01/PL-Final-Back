package com.example.BackFinal.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
public class AppUser  {
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Integer id;
    private String password;
    private String name;
    private String email;
    private String surname;
    @Enumerated(EnumType.STRING)
    private AppUserRole appRole;
    public AppUser() {
    }

    public AppUser(Integer id, String password, String name, String email, String surname, AppUserRole appRole, List<Pedido> pedidos) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.surname = surname;
        this.appRole = appRole;
        this.pedidos = pedidos;
    }

    @OneToMany(mappedBy = "usuario") //relacion usuario/pedido
    private List<Pedido> pedidos;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AppUserRole getAppRole() {
        return appRole;
    }

    public void setAppRole(AppUserRole appRole) {
        this.appRole = appRole;
    }
}
