package com.example.msventa.controller;


import com.example.msventa.Dto.DetalleDto;
import com.example.msventa.entity.Factura;
import com.example.msventa.service.DetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.msventa.entity.Detalle;


@RestController
@RequestMapping("/detalle")

public class DetalleController {
    @Autowired
    private DetalleService detalleService;

    @GetMapping
    public List<Detalle> findAll() {
        return detalleService.findAll();
    }

    @GetMapping("/{id}")
    public Detalle findById(@PathVariable int id) {
        return detalleService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Detalle> create(@RequestBody DetalleDto dto) {
        Detalle nuevaDetalle = detalleService.Save(dto);
        return ResponseEntity.ok(nuevaDetalle);
    }

    @PutMapping
    public Detalle update(@RequestBody Detalle detalle) {
        return detalleService.update(detalle);
    }
}
