package com.example.BackFinal;

import com.example.BackFinal.exceptions.ResourceNotFoundException;
import com.example.BackFinal.model.AppUser;
import com.example.BackFinal.model.AppUserRole;
import com.example.BackFinal.model.Pedido;
import com.example.BackFinal.model.Producto;
import com.example.BackFinal.service.PedidoService;
import com.example.BackFinal.service.ProductoService;
import com.example.BackFinal.service.UserService;
import org.apache.catalina.User;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class PedidoServiceTests {
    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private ProductoService productoService;

    public void cargarDataSet() {
        Date fecha = new Date(123, 9, 16, 12, 35, 42);
        this.pedidoService.GuardarPedido(new Pedido(fecha, "Ejemplo de Estado", new ArrayList<>()));
    }

    @Test
    public void agregarProducto() {
        Date fecha = new Date(123, 9, 16, 12, 35, 42);

        // Crea productos y guárdalos
        Producto producto1 = new Producto("Computadora", 1000, "Notebooks", "", "HP", "");
        Producto producto2 = new Producto("Impresora", 200, "Impresoras", "", "Epson", "");

        producto1 = productoService.GuardarProducto(producto1);
        producto2 = productoService.GuardarProducto(producto2);

        // Crea un nuevo pedido y agrega los productos a la lista
        Pedido pedido = new Pedido(fecha, "Ejemplo de Estado", new ArrayList<>());
        pedido.getProductos().add(producto1);
        pedido.getProductos().add(producto2);

        pedido = pedidoService.GuardarPedido(pedido);

        Assert.assertTrue(pedido.getId() != null);
        Assert.assertEquals(2, pedido.getProductos().size());
    }

    @Test
    public void eliminarProductoTest() throws ResourceNotFoundException {
        pedidoService.eliminar(8);
        Assert.assertTrue(pedidoService.buscar(8).isEmpty());
    }
    @Test
    public void traerTodos() {
        List<Pedido> pedido = pedidoService.buscarTodos();
        Assert.assertTrue(!pedido.isEmpty());
        Assert.assertTrue(pedido.size() >= 1);
        System.out.println(pedido);
    }
}
