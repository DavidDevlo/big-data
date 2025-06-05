package com.example.msventa.Util;


import com.example.msventa.entity.Pago;
import com.example.msventa.repository.PagoRepository;
import com.example.msventa.repository.VentaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class PagoSeeder implements CommandLineRunner {

    private final PagoRepository pagoRepository;
    private final VentaRepository ventaRepository;

    public PagoSeeder(PagoRepository pagoRepository, VentaRepository ventaRepository) {
        this.pagoRepository = pagoRepository;
        this.ventaRepository = ventaRepository;
    }

    @Override
    public void run(String... args) {
        if (pagoRepository.count() == 0) {
            List<Pago> pagos = List.of(
                    new Pago(null, ventaRepository.findById(1).orElse(null), LocalDateTime.of(2025, 6, 1, 10, 15), new BigDecimal("150.00"), "PROCESADO", "Efectivo", "REC001"),
                    new Pago(null, ventaRepository.findById(2).orElse(null), LocalDateTime.of(2025, 6, 1, 11, 30), new BigDecimal("80.00"), "PROCESADO", "Tarjeta", "TARJ002"),
                    new Pago(null, ventaRepository.findById(4).orElse(null), LocalDateTime.of(2025, 6, 2, 9, 45), new BigDecimal("60.00"), "PROCESADO", "Efectivo", "REC004"),
                    new Pago(null, ventaRepository.findById(5).orElse(null), LocalDateTime.of(2025, 6, 2, 13, 00), new BigDecimal("250.00"), "PROCESADO", "Tarjeta", "TARJ005"),
                    new Pago(null, ventaRepository.findById(7).orElse(null), LocalDateTime.of(2025, 6, 3, 14, 20), new BigDecimal("180.00"), "PROCESADO", "Efectivo", "REC007"),
                    new Pago(null, ventaRepository.findById(8).orElse(null), LocalDateTime.of(2025, 6, 3, 15, 00), new BigDecimal("75.00"), "PROCESADO", "Tarjeta", "TARJ008"),
                    new Pago(null, ventaRepository.findById(10).orElse(null), LocalDateTime.of(2025, 6, 4, 10, 05), new BigDecimal("200.00"), "PROCESADO", "Efectivo", "REC010"),
                    new Pago(null, ventaRepository.findById(11).orElse(null), LocalDateTime.of(2025, 6, 4, 11, 10), new BigDecimal("95.00"), "PROCESADO", "Tarjeta", "TARJ011"),
                    new Pago(null, ventaRepository.findById(13).orElse(null), LocalDateTime.of(2025, 6, 5, 12, 00), new BigDecimal("165.00"), "PROCESADO", "Efectivo", "REC013"),
                    new Pago(null, ventaRepository.findById(14).orElse(null), LocalDateTime.of(2025, 6, 6, 9, 30), new BigDecimal("85.00"), "PROCESADO", "Tarjeta", "TARJ014"),
                    new Pago(null, ventaRepository.findById(15).orElse(null), LocalDateTime.of(2025, 6, 6, 10, 20), new BigDecimal("45.00"), "PROCESADO", "Efectivo", "REC015")
            );

            pagoRepository.saveAll(pagos);
            System.out.println("✅ Pagos insertados correctamente.");
        } else {
            System.out.println("ℹ️ Ya existen pagos.");
        }
    }
}
