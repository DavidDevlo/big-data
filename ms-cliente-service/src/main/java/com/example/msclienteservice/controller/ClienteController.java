package com.example.msclienteservice.controller;


import com.example.msclienteservice.entity.Cliente;
import com.example.msclienteservice.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Obtener todas las categorías
    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        System.out.println("Listando clientes");
        List<Cliente> clientes = clienteService.listar();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    // Obtener una categoría por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable Integer id) {
        Optional<Cliente> cliente = clienteService.buscar(id);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva categoría
    @PostMapping
    public ResponseEntity<Cliente> crearRol(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteService.guardar(cliente);
        return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
    }

    // Actualizar una categoría existente
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
        Cliente clienteActualizado = clienteService.actualizar(id, cliente);
        return clienteActualizado != null ? new ResponseEntity<>(clienteActualizado, HttpStatus.OK)
                : ResponseEntity.notFound().build();
    }

    // Eliminar una categoría por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRol(@PathVariable Integer id) {
        clienteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
