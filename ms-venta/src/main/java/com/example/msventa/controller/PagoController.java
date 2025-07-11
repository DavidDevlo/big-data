package com.example.msventa.controller;


import com.example.msventa.Dto.PagoDto;
import com.example.msventa.entity.Pago;
import com.example.msventa.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @GetMapping
    public List<Pago> listar() {
        return pagoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pago> buscar(@PathVariable Integer id) {
        Optional<Pago> pago = pagoService.buscar(id);
        if (pago.isPresent()) {
            return ResponseEntity.ok(pago.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Pago> crearPago(@RequestBody PagoDto dto) {
        Pago nuevoPago = pagoService.crearPago(dto);
        return ResponseEntity.ok(nuevoPago);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pago> actualizar(@PathVariable Integer id, @RequestBody Pago pago) {
        Pago pagoActualizado = pagoService.actualizar(id, pago);
        if (pagoActualizado != null) {
            return ResponseEntity.ok(pagoActualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        pagoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarPago(@RequestBody PagoDto pagoDto) {
        pagoService.registrarPago(pagoDto);
        return ResponseEntity.ok("Pago registrado correctamente.");
    }
    @GetMapping("/total-pagado/{ventaId}")
    public ResponseEntity<BigDecimal> obtenerTotalPagado(@PathVariable Integer ventaId) {
        BigDecimal totalPagado = pagoService.obtenerTotalPagado(ventaId);
        return ResponseEntity.ok(totalPagado != null ? totalPagado : BigDecimal.ZERO);
    }
    @GetMapping("/venta/{ventaId}")
    public ResponseEntity<List<Pago>> listarPagosPorVenta(@PathVariable Integer ventaId) {
        List<Pago> pagos = pagoService.obtenerPagosPorVenta(ventaId);
        return ResponseEntity.ok(pagos);
    }



}
