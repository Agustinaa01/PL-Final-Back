package com.example.BackFinal.service;

import com.example.BackFinal.exceptions.BadRequestException;
import com.example.BackFinal.exceptions.ResourceNotFoundException;
import com.example.BackFinal.model.Pedido;
import com.example.BackFinal.model.Producto;
import com.example.BackFinal.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;


    @Autowired
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }
    public Pedido guardarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
    public void eliminar(Integer id) throws ResourceNotFoundException {
        if (buscar(id).isEmpty())
            throw new ResourceNotFoundException("No existe el pedido con el id: " + id);
        pedidoRepository.deleteById(id);
    }
    public Optional<Pedido> buscar(Integer id) {
        return pedidoRepository.findById(id);
    }
    public List<Pedido> buscarTodos() {
        return pedidoRepository.findAll();
    }


    public Pedido actualizar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
}
