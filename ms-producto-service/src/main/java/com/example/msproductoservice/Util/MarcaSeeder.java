package com.example.msproductoservice.Util;

import com.example.msproductoservice.entity.Marca;
import com.example.msproductoservice.repository.MarcaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MarcaSeeder implements CommandLineRunner {

    private final MarcaRepository marcaRepository;

    public MarcaSeeder(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    @Override
    public void run(String... args) {
        if (marcaRepository.count() == 0) {
            List<Marca> marcas = List.of(
                    new Marca(null, "Nike"),
            new Marca(null, "Adidas"),
            new Marca(null, "Puma"),
            new Marca(null, "New Balance"),
            new Marca(null, "Converse"),
            new Marca(null, "Vans"),
            new Marca(null, "Reebok"),
            new Marca(null, "Skechers"),
            new Marca(null, "Fila"),
            new Marca(null, "Asics")
            );
            marcaRepository.saveAll(marcas);
            System.out.println("✅ Marcas insertadas correctamente.");
        } else {
            System.out.println("ℹ️ Las marcas ya existen, no se insertaron datos.");
        }
    }
}
