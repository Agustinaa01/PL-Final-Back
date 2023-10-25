package com.example.BackFinal.service;

import com.example.BackFinal.exceptions.ResourceNotFoundException;
import com.example.BackFinal.model.Pedido;
import com.example.BackFinal.model.Producto;
import com.example.BackFinal.repository.PedidoRepository;
import com.example.BackFinal.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {

        this.productoRepository = productoRepository;
    }
    public Producto GuardarProducto(Producto producto) {

        return productoRepository.save(producto);
    }
    public void eliminar(Integer id) throws ResourceNotFoundException {
        if (buscar(id).isEmpty())
            throw new ResourceNotFoundException("No existe el producto con el id: " + id);
        productoRepository.deleteById(id);
    }
    public Optional<Producto> buscar(Integer id) {
        return productoRepository.findById(id);
    }
    public List<Producto> buscarTodos() {
        return productoRepository.findAll();
    }

    public Producto actualizar(Producto producto) {

        return productoRepository.save(producto);
    }
}

