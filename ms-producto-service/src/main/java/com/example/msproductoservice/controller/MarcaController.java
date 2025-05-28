package com.example.msproductoservice.controller;



import com.example.msproductoservice.entity.Marca;
import com.example.msproductoservice.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/marcas")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    // Obtener todos los proveedores
    @GetMapping
    public ResponseEntity<List<Marca>> listarMarcas() {
        List<Marca> marcas = marcaService.listar();
        return new ResponseEntity<>(marcas, HttpStatus.OK);
    }

    // Obtener un proveedor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Marca> buscarMarca(@PathVariable Integer id) {
        Optional<Marca> marca = marcaService.buscar(id);
        return marca.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo proveedor
    @PostMapping
    public ResponseEntity<Marca> crearMarca(@RequestBody Marca marca) {
        Marca nuevoMarca = marcaService.guardar(marca);
        return new ResponseEntity<>(nuevoMarca, HttpStatus.CREATED);
    }

    // Actualizar un proveedor existente
    @PutMapping("/{id}")
    public ResponseEntity<Marca> actualizarMarca(@PathVariable Integer id, @RequestBody Marca marca) {
        Marca marcaActualizado = marcaService.actualizar(id, marca);
        return marcaActualizado != null ? new ResponseEntity<>(marcaActualizado, HttpStatus.OK)
                : ResponseEntity.notFound().build();
    }

    // Eliminar un proveedor por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMarca(@PathVariable Integer id) {
        marcaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

