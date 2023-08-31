package com.example.BackFinal.repository;

import com.example.BackFinal.model.Pedido;
import com.example.BackFinal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
