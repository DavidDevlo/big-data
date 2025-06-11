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
                    new Categoria(null, "Zapatillas Urbanas"),
            new Categoria(null, "Zapatillas Deportivas"),
            new Categoria(null, "Zapatillas de Running"),
            new Categoria(null, "Zapatillas de Entrenamiento"),
            new Categoria(null, "Zapatillas de Baloncesto"),
            new Categoria(null, "Zapatillas para Niños"),
            new Categoria(null, "Zapatillas de Outdoor")
            );
            categoriaRepository.saveAll(categorias);
            System.out.println("✅ Categorías insertadas correctamente.");
        } else {
            System.out.println("ℹ️ Las categorías ya existen, no se insertaron datos.");
        }
    }
}
