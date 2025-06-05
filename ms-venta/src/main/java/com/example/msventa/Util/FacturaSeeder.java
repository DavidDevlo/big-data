package com.example.msventa.Util;

import com.example.msventa.entity.Factura;
import com.example.msventa.entity.Pago;
import com.example.msventa.repository.FacturaRepository;
import com.example.msventa.repository.PagoRepository;
import com.example.msventa.repository.VentaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import java.time.LocalDateTime;
import java.util.List;


@Component
public class FacturaSeeder implements CommandLineRunner {

    private final FacturaRepository facturaRepository;
    private final VentaRepository ventaRepository;

    public FacturaSeeder(FacturaRepository facturaRepository, VentaRepository ventaRepository) {
        this.facturaRepository = facturaRepository;
        this.ventaRepository = ventaRepository;
    }

    @Override
    public void run(String... args) {
        if (facturaRepository.count() == 0) {
            List<Factura> facturas = List.of(
                    new Factura(null, "EMITIDA", LocalDateTime.of(2025, 6, 1, 10, 20), "FAC-2025-001", ventaRepository.findById(1).orElse(null)),
                    new Factura(null, "EMITIDA", LocalDateTime.of(2025, 6, 1, 11, 35), "FAC-2025-002", ventaRepository.findById(2).orElse(null)),
                    new Factura(null, "EMITIDA", LocalDateTime.of(2025, 6, 2, 9, 50), "FAC-2025-003", ventaRepository.findById(4).orElse(null)),
                    new Factura(null, "EMITIDA", LocalDateTime.of(2025, 6, 2, 13, 5), "FAC-2025-004", ventaRepository.findById(5).orElse(null)),
                    new Factura(null, "EMITIDA", LocalDateTime.of(2025, 6, 3, 14, 25), "FAC-2025-005", ventaRepository.findById(7).orElse(null)),
                    new Factura(null, "EMITIDA", LocalDateTime.of(2025, 6, 3, 15, 5), "FAC-2025-006", ventaRepository.findById(8).orElse(null)),
                    new Factura(null, "EMITIDA", LocalDateTime.of(2025, 6, 4, 10, 10), "FAC-2025-007", ventaRepository.findById(10).orElse(null)),
                    new Factura(null, "EMITIDA", LocalDateTime.of(2025, 6, 4, 11, 15), "FAC-2025-008", ventaRepository.findById(11).orElse(null)),
                    new Factura(null, "EMITIDA", LocalDateTime.of(2025, 6, 5, 12, 10), "FAC-2025-009", ventaRepository.findById(13).orElse(null)),
                    new Factura(null, "EMITIDA", LocalDateTime.of(2025, 6, 6, 9, 35), "FAC-2025-010", ventaRepository.findById(14).orElse(null)),
                    new Factura(null, "EMITIDA", LocalDateTime.of(2025, 6, 6, 10, 25), "FAC-2025-011", ventaRepository.findById(15).orElse(null))
            );

            facturaRepository.saveAll(facturas);
            System.out.println("✅ Facturas insertadas correctamente.");
        } else {
            System.out.println("ℹ️ Ya existen facturas.");
        }
    }
}
