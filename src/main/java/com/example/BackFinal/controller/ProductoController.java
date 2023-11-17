
package com.example.BackFinal.controller;

import com.example.BackFinal.exceptions.ResourceNotFoundException;
import com.example.BackFinal.model.Producto;
import com.example.BackFinal.service.ProductoService;
import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@CrossOrigin
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @PostMapping("/crear")
    public ResponseEntity<Producto> registrarProducto(@RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.GuardarProducto(producto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscar(@PathVariable Integer id) {
        Producto producto = productoService.buscar(id).orElse(null);
        return ResponseEntity.ok(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@RequestBody Producto producto) {
        ResponseEntity<Producto> response = null;
        response = ResponseEntity.ok(productoService.actualizar(producto));
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        try {
            productoService.eliminar(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Producto Eliminado");
        } catch (ResourceNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo encontrar el usuario con el ID proporcionado: " + e.getMessage());

        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Producto>> buscarTodos(){
        return ResponseEntity.ok(productoService.buscarTodos());
    }
}
