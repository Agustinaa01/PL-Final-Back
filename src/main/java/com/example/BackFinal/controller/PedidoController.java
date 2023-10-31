package com.example.BackFinal.controller;

import com.example.BackFinal.exceptions.ResourceNotFoundException;
import com.example.BackFinal.model.Pedido;
import com.example.BackFinal.model.Producto;
import com.example.BackFinal.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/crear")
    public ResponseEntity<Pedido> registrarPedido(@RequestBody Pedido pedido) {
        return ResponseEntity.ok(pedidoService.guardarPedido(pedido));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscar(@PathVariable Integer id) {
        Pedido pedido = pedidoService.buscar(id).orElse(null);
        return ResponseEntity.ok(pedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> actualizar(@RequestBody Pedido pedido) {
        ResponseEntity<Pedido> response = null;
        if (pedido.getId() != null && pedidoService.buscar(pedido.getId()).isPresent())
            response = ResponseEntity.ok(pedidoService.actualizar(pedido));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        try {
             pedidoService.eliminar(id);
              return ResponseEntity.status(HttpStatus.NO_CONTENT).body(" Pedido Eliminado");
        } catch ( ResourceNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo encontrar el pedido con el ID proporcionado: " + e.getMessage());
        }


    }

    @GetMapping("/")
    public ResponseEntity<List<Pedido>> buscarTodos(){
        return ResponseEntity.ok(pedidoService.buscarTodos());
    }
}

