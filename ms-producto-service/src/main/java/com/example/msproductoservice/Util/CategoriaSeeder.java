package com.example.msproductoservice.Util;

import com.example.msproductoservice.entity.Categoria;
import com.example.msproductoservice.repository.CategoriaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaSeeder implements CommandLineRunner {

    private final CategoriaRepository categoriaRepository;

    public CategoriaSeeder(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public void run(String... args) {
        if (categoriaRepository.count() == 0) {
            List<Categoria> categorias = List.of(
                    new Categoria(null, "Tela"),
                    new Categoria(null, "Insumo"),
                    new Categoria(null, "Herramienta"),
                    new Categoria(null, "Maquinaria"),
                    new Categoria(null, "Accesorio"),
                    new Categoria(null, "Combo exportación"),
                    new Categoria(null, "Embalaje")
            );
            categoriaRepository.saveAll(categorias);
            System.out.println("✅ Categorías insertadas correctamente.");
        } else {
            System.out.println("ℹ️ Las categorías ya existen, no se insertaron datos.");
        }
    }
}
