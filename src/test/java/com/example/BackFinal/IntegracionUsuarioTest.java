package com.example.BackFinal;

import com.example.BackFinal.model.Pedido;
import com.example.BackFinal.model.Producto;
import com.example.BackFinal.service.PedidoService;
import com.example.BackFinal.service.ProductoService;
import com.example.BackFinal.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class IntegracionUsuarioTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ProductoService productoService;
    @Autowired
    private PedidoService pedidoService;

    public void cargarDataSet() {
        Date fecha = new Date(123, 9, 16, 12, 35, 42); // Año, mes (enero=0, febrero=1, marzo=2, ...), día, hora, minutos, segundos
        Pedido pedido = new Pedido(fecha, "Ejemplo de Estado", new ArrayList<>());
        Producto p = productoService.GuardarProducto(new Producto("Ejemplo Brand", 19.99, "Ejemplo de Producto", "Este es un ejemplo de descripción del producto", "Ejemplo de Producto", "https://ejemplo.com/imagen.png"));
    }

    @Test
    public void listarProducto() throws Exception {
        this.cargarDataSet();
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/pedidos/{id}", 2
                ).accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());
    }
}
