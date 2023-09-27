package com.example.BackFinal.controller;

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
        ResponseEntity<String> response = null;
        if (userService.buscar(id).isPresent()) {
            userService.eliminar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<List<AppUser>> buscarTodos(){
        return ResponseEntity.ok(userService.buscarTodos());
    }
}
