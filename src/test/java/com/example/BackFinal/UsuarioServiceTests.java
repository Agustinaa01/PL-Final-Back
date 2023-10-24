package com.example.BackFinal;

import com.example.BackFinal.exceptions.ResourceNotFoundException;
import com.example.BackFinal.model.AppUser;
import com.example.BackFinal.model.AppUserRole;
import com.example.BackFinal.model.Pedido;
import com.example.BackFinal.model.Producto;
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
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioServiceTests {
    @Autowired
    private UserService userService;

    public void cargarDataSet() {
        this.userService.GuardarUser(new AppUser("1234", "Agus", "agus@gmail.com", AppUserRole.USER,new ArrayList<>()));
    }
    @Test
    public void agregarUsuario() {
        this.cargarDataSet();
        AppUser usr = userService.GuardarUser(new AppUser("1234", "Agus", "agus@gmail.com", AppUserRole.USER,new ArrayList<>()));
        Assert.assertTrue(usr.getId() != null);
    }
    @Test
    public void eliminarUsuarioTest() throws ResourceNotFoundException {
        userService.eliminar(10);
        Assert.assertTrue(userService.buscar(10).isEmpty());
    }
    @Test
    public void traerTodos() {
        List<AppUser> usr = userService.buscarTodos();
        Assert.assertTrue(!usr.isEmpty());
        Assert.assertTrue(usr.size() >= 1);
        System.out.println(usr);
    }
}
