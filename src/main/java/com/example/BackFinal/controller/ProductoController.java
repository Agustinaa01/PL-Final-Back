
package com.example.BackFinal.controller;

import com.example.BackFinal.model.Producto;
import com.example.BackFinal.service.ProductoService;
import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @PostMapping("/productos")
    public ResponseEntity<Producto> registrarProducto(@RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.GuardarProducto(producto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscar(@PathVariable Integer id) {
        Producto producto = productoService.buscar(id).orElse(null);
        return ResponseEntity.ok(producto);
    }

    @PutMapping()
    public ResponseEntity<Producto> actualizar(@RequestBody Producto producto) {
        ResponseEntity<Producto> response = null;
        if (producto.getId() != null && productoService.buscar(producto.getId()).isPresent())
            response = ResponseEntity.ok(productoService.actualizar(producto));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        ResponseEntity<String> response = null;
        if (productoService.buscar(id).isPresent()) {
            productoService.eliminar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<List<Producto>> buscarTodos(){
        return ResponseEntity.ok(productoService.buscarTodos());
    }
}
