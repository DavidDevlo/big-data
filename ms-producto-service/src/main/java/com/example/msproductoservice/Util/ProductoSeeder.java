package com.example.msproductoservice.Util;

import com.example.msproductoservice.entity.Categoria;
import com.example.msproductoservice.entity.Marca;
import com.example.msproductoservice.entity.Producto;
import com.example.msproductoservice.repository.CategoriaRepository;
import com.example.msproductoservice.repository.MarcaRepository;
import com.example.msproductoservice.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ProductoSeeder implements CommandLineRunner {

    private final ProductoRepository productoRepository;

    public ProductoSeeder(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public void run(String... args) {
        if (productoRepository.count() == 0) {

            Categoria cat1 = new Categoria(1, null);
            Categoria cat2 = new Categoria(2, null);
            Categoria cat3 = new Categoria(3, null);

            Marca marca1 = new Marca(1, null);
            Marca marca2 = new Marca(2, null);
            Marca marca3 = new Marca(3, null);

            List<Producto> productos = List.of(
                    new Producto(1, cat1, marca1, 10, 120.0, "Tela ligera para camisas y vestidos", "Tela de algodón estampada"),
                    new Producto(2, cat1, marca2, 15, 90.0, "Tela de alpaca combinada con acrílico", "Tela alpácril fina"),
                    new Producto(3, cat2, marca3, 20, 60.0, "Tela sintética resistente", "Tela dralón resistente"),
                    new Producto(4, cat3, marca1, 10, 150.0, "Tela suave y cálida, 100% alpaca", "Tela de alpaca premium"),
                    new Producto(5, cat2, marca2, 12, 80.0, "Algodón grueso ideal para mantas", "Tela de algodón gruesa"),
                    new Producto(6, cat3, marca3, 18, 55.0, "Tela dralón liviana para ropa deportiva", "Tela dralón deportiva"),
                    new Producto(7, cat2, marca1, 14, 130.0, "Tela de alpaca con diseño andino", "Tela alpaca diseño tradicional"),
                    new Producto(8, cat1, marca2, 10, 100.0, "Tela de algodón para prendas frescas", "Tela algodón tropical"),
                    new Producto(9, cat3, marca3, 16, 70.0, "Tela dralón estampado moderno", "Tela dralón estampada"),
                    new Producto(10, cat2, marca1, 12, 140.0, "Tela de alpaca teñida artesanalmente", "Tela alpaca teñida artesanal")
            );

            productoRepository.saveAll(productos);
            System.out.println("✅ Productos insertados correctamente.");
        } else {
            System.out.println("ℹ️ Los productos ya existen, no se insertaron datos.");
        }
    }
}
