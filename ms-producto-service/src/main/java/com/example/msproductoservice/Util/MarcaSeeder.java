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
                    new Marca(null, "TexAlpaca"),
                    new Marca(null, "Indutech"),
                    new Marca(null, "CosturaPro"),
                    new Marca(null, "VaporiX"),
                    new Marca(null, "ExportLine"),
                    new Marca(null, "Hilandera Andina"),
                    new Marca(null, "MaqTex")
            );
            marcaRepository.saveAll(marcas);
            System.out.println("✅ Marcas insertadas correctamente.");
        } else {
            System.out.println("ℹ️ Las marcas ya existen, no se insertaron datos.");
        }
    }
}
