package com.example.msventa.Util;


import com.example.msventa.entity.Venta;
import com.example.msventa.repository.VentaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class VentaSeeder implements CommandLineRunner {

    private final VentaRepository ventaRepository;

    public VentaSeeder(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    @Override
    public void run(String... args) {
        if (ventaRepository.count() == 0) {
            List<Venta> ventas = List.of(
                    new Venta(null, LocalDateTime.parse("2025-06-01T10:00:00"), "Efectivo", new BigDecimal("150.0"), "COMPLETADO", 1, null, 1, null),
                    new Venta(null, LocalDateTime.parse("2025-06-01T11:00:00"), "Tarjeta", new BigDecimal("80.0"), "COMPLETADO", 2, null, 2, null),
                    new Venta(null, LocalDateTime.parse("2025-06-01T12:00:00"), "Transferencia", new BigDecimal("320.0"), "PENDIENTE", 3, null, 3, null),
                    new Venta(null, LocalDateTime.parse("2025-06-02T09:30:00"), "Efectivo", new BigDecimal("60.0"), "COMPLETADO", 4, null, 1, null),
                    new Venta(null, LocalDateTime.parse("2025-06-02T10:15:00"), "Tarjeta", new BigDecimal("250.0"), "COMPLETADO", 5, null, 2, null),
                    new Venta(null, LocalDateTime.parse("2025-06-03T14:00:00"), "Transferencia", new BigDecimal("100.0"), "ANULADO", 6, null, 3, null),
                    new Venta(null, LocalDateTime.parse("2025-06-03T15:30:00"), "Efectivo", new BigDecimal("180.0"), "COMPLETADO", 7, null, 1, null),
                    new Venta(null, LocalDateTime.parse("2025-06-03T16:00:00"), "Tarjeta", new BigDecimal("75.0"), "COMPLETADO", 8, null, 2, null),
                    new Venta(null, LocalDateTime.parse("2025-06-04T09:00:00"), "Transferencia", new BigDecimal("50.0"), "PENDIENTE", 9, null, 3, null),
                    new Venta(null, LocalDateTime.parse("2025-06-04T10:45:00"), "Efectivo", new BigDecimal("200.0"), "COMPLETADO", 10, null, 1, null),
                    new Venta(null, LocalDateTime.parse("2025-06-04T11:30:00"), "Tarjeta", new BigDecimal("95.0"), "COMPLETADO", 11, null, 2, null),
                    new Venta(null, LocalDateTime.parse("2025-06-05T13:00:00"), "Transferencia", new BigDecimal("130.0"), "PENDIENTE", 12, null, 3, null),
                    new Venta(null, LocalDateTime.parse("2025-06-05T14:20:00"), "Efectivo", new BigDecimal("165.0"), "COMPLETADO", 13, null, 1, null),
                    new Venta(null, LocalDateTime.parse("2025-06-06T09:50:00"), "Tarjeta", new BigDecimal("85.0"), "COMPLETADO", 14, null, 2, null),
                    new Venta(null, LocalDateTime.parse("2025-06-06T11:00:00"), "Efectivo", new BigDecimal("45.0"), "COMPLETADO", 15, null, 3, null)
            );

            ventaRepository.saveAll(ventas);
            System.out.println("✅ Ventas insertadas correctamente.");
        } else {
            System.out.println("ℹ️ Las ventas ya existen, no se insertaron.");
        }
    }
}