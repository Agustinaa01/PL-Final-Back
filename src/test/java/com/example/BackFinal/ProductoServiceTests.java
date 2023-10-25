package com.example.BackFinal;

import com.example.BackFinal.exceptions.ResourceNotFoundException;
import com.example.BackFinal.model.Pedido;
import com.example.BackFinal.model.Producto;
import com.example.BackFinal.service.ProductoService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductoServiceTests {
    @Autowired
    private ProductoService productoService;

    public void cargarDataSet() {
        this.productoService.GuardarProducto(new Producto("Computadora", 1000, "Notebooks", "", "HP", ""));
    }
    @Test
    public void agregarProducto() {
        this.cargarDataSet();
        Producto producto = productoService.GuardarProducto(new Producto("Auriculares", 2000, "Auriculares", "computadora Sony...", "Sony", ""));
        Assert.assertTrue(producto.getId() != null);
    }
    @Test
    public void eliminarProductoTest() throws ResourceNotFoundException {
        productoService.eliminar(18);
        Assert.assertTrue(productoService.buscar(18).isEmpty());
    }
    @Test
    public void traerTodos() {
        List<Producto> productos = productoService.buscarTodos();
        Assert.assertTrue(!productos.isEmpty());
        Assert.assertTrue(productos.size() >= 1);
        System.out.println(productos);
    }
}
