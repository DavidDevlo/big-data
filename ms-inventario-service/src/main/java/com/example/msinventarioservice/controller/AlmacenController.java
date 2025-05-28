package com.example.msinventarioservice.controller;

import com.example.msinventarioservice.entity.Almacen;
import com.example.msinventarioservice.service.AlmacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/almacenes")
public class AlmacenController {

    @Autowired
    private AlmacenService almacenService;

    // Obtener todos los almacenes
    @GetMapping
    public ResponseEntity<List<Almacen>> listarAlmacenes() {
        List<Almacen> almacenes = almacenService.listar();
        return new ResponseEntity<>(almacenes, HttpStatus.OK);
    }

    // Obtener un almacén por ID
    @GetMapping("/{id}")
    public ResponseEntity<Almacen> buscarAlmacen(@PathVariable Integer id) {
        Optional<Almacen> almacen = almacenService.buscar(id);
        return almacen.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo almacén
    @PostMapping
    public ResponseEntity<Almacen> crearAlmacen(@RequestBody Almacen almacen) {
        Almacen nuevoAlmacen = almacenService.guardar(almacen);
        return new ResponseEntity<>(nuevoAlmacen, HttpStatus.CREATED);
    }

    // Actualizar un almacén existente
    @PutMapping("/{id}")
    public ResponseEntity<Almacen> actualizarAlmacen(@PathVariable Integer id, @RequestBody Almacen almacen) {
        Almacen almacenActualizado = almacenService.actualizar(id, almacen);
        return almacenActualizado != null ? new ResponseEntity<>(almacenActualizado, HttpStatus.OK)
                : ResponseEntity.notFound().build();
    }

    // Eliminar un almacén por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAlmacen(@PathVariable Integer id) {
        almacenService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
