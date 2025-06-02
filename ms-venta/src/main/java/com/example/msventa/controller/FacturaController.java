package com.example.msventa.controller;

import com.example.msventa.Dto.FacturaDto;
import com.example.msventa.entity.Factura;
import com.example.msventa.service.FacturaService;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/facturas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @GetMapping
    public List<Factura> listar() {
        return facturaService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Factura> buscar(@PathVariable Integer id) {
        Optional<Factura> factura = facturaService.buscar(id);
        if (factura.isPresent()) {
            return ResponseEntity.ok(factura.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Factura> crearFactura(@RequestBody FacturaDto dto) {
        Factura nuevaFactura = facturaService.crearFactura(dto);
        return ResponseEntity.ok(nuevaFactura);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Factura> actualizar(@PathVariable Integer id, @RequestBody Factura factura) {
        Factura facturaActualizada = facturaService.actualizar(id, factura);
        if (facturaActualizada != null) {
            return ResponseEntity.ok(facturaActualizada);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        facturaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
