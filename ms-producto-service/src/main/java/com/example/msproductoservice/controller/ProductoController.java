package com.example.msproductoservice.controller;

import com.example.msproductoservice.Dto.ProductoDto;
import com.example.msproductoservice.entity.Producto;
import com.example.msproductoservice.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> listar() {
        return productoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDto> buscar(@PathVariable Integer id) {
        Optional<Producto> producto = productoService.buscar(id);
        if (producto.isPresent()) {
            ProductoDto dto = convertirAProductoDto(producto.get());
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.notFound().build();
    }
    private ProductoDto convertirAProductoDto(Producto producto) {
        ProductoDto dto = new ProductoDto();
        dto.setId(producto.getId()); // ✅ ahora sí asigna bien el ID
        dto.setNombre(producto.getNombre());
        dto.setDescripcion(producto.getDescripcion());
        dto.setPrecio(producto.getPrecio());
        dto.setStockMinimo(producto.getStockMinimo());
        dto.setImagenUrl(producto.getImagenUrl());
        dto.setMarcaId(producto.getMarca().getId());
        dto.setCategoriaId(producto.getCategoria().getId());
        return dto;
    }



    @PostMapping
    public ResponseEntity<Producto> crear(@RequestBody ProductoDto dto) {
        Producto nuevoProducto = productoService.guardar(dto);
        return ResponseEntity.ok(nuevoProducto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Integer id, @RequestBody Producto producto) {
        Producto actualizado = productoService.actualizar(id, producto);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        productoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/upload-image")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String folder = "uploads/";
            String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
            Path path = Paths.get(folder + filename);
            Files.createDirectories(path.getParent());
            Files.copy(file.getInputStream(), path);
            return ResponseEntity.ok(filename);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir imagen");
        }
}
}
