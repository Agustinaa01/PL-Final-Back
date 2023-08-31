package com.example.BackFinal.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.List;
@Entity
@DiscriminatorValue("cliente")
public class UserCliente extends User{
    public UserCliente(Integer id, String nombre, String email) {
        super(id, nombre, email);
    }

    public UserCliente() {

    }
}
