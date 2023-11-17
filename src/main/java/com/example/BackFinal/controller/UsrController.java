package com.example.BackFinal.controller;

import com.example.BackFinal.exceptions.ResourceNotFoundException;
import com.example.BackFinal.model.AppUser;
import com.example.BackFinal.model.Producto;
import com.example.BackFinal.service.ProductoService;
import com.example.BackFinal.service.UserService;
import org.apache.catalina.User;
import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin

public class UsrController {
    @Autowired
    private UserService userService;

    @PostMapping("/crear")
    public ResponseEntity<AppUser> registrarUsuarios(@RequestBody AppUser user) {
        return ResponseEntity.ok(userService.GuardarUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUser> buscar(@PathVariable Integer id) {
        AppUser user = userService.buscar(id).orElse(null);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppUser> actualizar(@RequestBody AppUser user) {
        ResponseEntity<AppUser> response = null;
        if (user.getId() != null && userService.buscar(user.getId()).isPresent())
            response = ResponseEntity.ok(userService.actualizar(user));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        try {
            userService.eliminar(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Usuario Eliminado");
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo encontrar el usuario con el ID proporcionado: " + e.getMessage());
        }
    }


    @GetMapping("/")
    public ResponseEntity<List<AppUser>> buscarTodos(){
        return ResponseEntity.ok(userService.buscarTodos());
    }
}
