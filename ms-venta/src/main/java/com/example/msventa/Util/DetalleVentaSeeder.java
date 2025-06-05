package com.example.msventa.Util;

import com.example.msventa.entity.Detalle;
import com.example.msventa.repository.DetalleRepository;
import com.example.msventa.repository.VentaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class DetalleVentaSeeder implements CommandLineRunner {

    private final DetalleRepository detalleRepository;
    private final VentaRepository ventaRepository;

    public DetalleVentaSeeder(DetalleRepository detalleRepository, VentaRepository ventaRepository) {
        this.detalleRepository = detalleRepository;
        this.ventaRepository = ventaRepository;
    }

    @Override
    public void run(String... args) {
        if (detalleRepository.count() == 0) {
            List<Detalle> detalles = List.of(
                    new Detalle(null, null, 1, ventaRepository.findById(1).orElse(null), 2, 25.00),
                    new Detalle(null, null, 3, ventaRepository.findById(1).orElse(null), 1, 100.00),
                    new Detalle(null, null, 2, ventaRepository.findById(2).orElse(null), 1, 80.00),
                    new Detalle(null, null, 5, ventaRepository.findById(3).orElse(null), 4, 80.00),
                    new Detalle(null, null, 6, ventaRepository.findById(4).orElse(null), 2, 30.00),
                    new Detalle(null, null, 1, ventaRepository.findById(5).orElse(null), 5, 50.00),
                    new Detalle(null, null, 4, ventaRepository.findById(6).orElse(null), 2, 50.00),
                    new Detalle(null, null, 3, ventaRepository.findById(7).orElse(null), 1, 180.00),
                    new Detalle(null, null, 2, ventaRepository.findById(8).orElse(null), 3, 25.00),
                    new Detalle(null, null, 7, ventaRepository.findById(9).orElse(null), 1, 50.00),
                    new Detalle(null, null, 8, ventaRepository.findById(10).orElse(null), 2, 100.00),
                    new Detalle(null, null, 9, ventaRepository.findById(11).orElse(null), 1, 95.00),
                    new Detalle(null, null, 10, ventaRepository.findById(12).orElse(null), 2, 65.00),
                    new Detalle(null, null, 2, ventaRepository.findById(13).orElse(null), 3, 55.00),
                    new Detalle(null, null, 4, ventaRepository.findById(14).orElse(null), 1, 85.00),
                    new Detalle(null, null, 6, ventaRepository.findById(15).orElse(null), 2, 22.50)
            );

            detalleRepository.saveAll(detalles);
            System.out.println("✅ Detalles de venta insertados correctamente.");
        } else {
            System.out.println("ℹ️ Ya existen detalles de venta.");
        }
    }
}

