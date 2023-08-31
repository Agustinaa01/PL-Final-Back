package com.example.BackFinal.repository;

import com.example.BackFinal.model.Producto;
import com.example.BackFinal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
