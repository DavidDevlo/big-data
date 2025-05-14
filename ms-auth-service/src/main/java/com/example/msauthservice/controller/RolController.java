package com.example.msauthservice.controller;

import com.example.msauthservice.entity.Rol;
import com.example.msauthservice.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rol")
public class RolController {

    @Autowired
    private RolService rolService;

    // Obtener todas las categorías
    @GetMapping
    public ResponseEntity<List<Rol>> listarRol() {
        System.out.println("Listando roles");
        List<Rol> categorias = rolService.listar();
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }

    // Obtener una categoría por ID
    @GetMapping("/{id}")
    public ResponseEntity<Rol> buscarRol(@PathVariable Integer id) {
        Optional<Rol> rol = rolService.buscar(id);
        return rol.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva categoría
    @PostMapping
    public ResponseEntity<Rol> crearRol(@RequestBody Rol rol) {
        Rol nuevoRol = rolService.guardar(rol);
        return new ResponseEntity<>(nuevoRol, HttpStatus.CREATED);
    }

    // Actualizar una categoría existente
    @PutMapping("/{id}")
    public ResponseEntity<Rol> actualizarRol(@PathVariable Integer id, @RequestBody Rol rol) {
        Rol rolActualizada = rolService.actualizar(id, rol);
        return rolActualizada != null ? new ResponseEntity<>(rolActualizada, HttpStatus.OK)
                : ResponseEntity.notFound().build();
    }

    // Eliminar una categoría por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRol(@PathVariable Integer id) {
        rolService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
