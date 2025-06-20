package com.example.msventa.controller;



import com.example.msventa.Dto.VentaRequestDTO;
import com.example.msventa.Dto.VentaResponseDTO;
import com.example.msventa.entity.Venta;
import com.example.msventa.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venta")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public List<Venta> findAll() {
        return ventaService.findAll();
    }

    @GetMapping("/{id}")
    public Venta findById(@PathVariable int id) {
        return ventaService.findById(id);
    }

    @PostMapping
    public Venta create(@RequestBody Venta venta) {
        return ventaService.Save(venta);
    }

    @PutMapping
    public Venta update(@RequestBody Venta venta) {
        return ventaService.update(venta);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarVenta(@RequestBody VentaRequestDTO request) {
        VentaResponseDTO response = ventaService.registrarVentaConFactura(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}