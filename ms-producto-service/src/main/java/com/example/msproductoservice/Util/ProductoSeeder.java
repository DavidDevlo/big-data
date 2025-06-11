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
            Categoria cat4 = new Categoria(4, null);
            Categoria cat5 = new Categoria(5, null);


            Marca marca1 = new Marca(1, null);
            Marca marca2 = new Marca(2, null);
            Marca marca3 = new Marca(3, null);
            Marca marca4 = new Marca(4, null);
            Marca marca5 = new Marca(5, null);

            List<Producto> productos = List.of(
                    new Producto(1, cat1, marca5, 10, 85.0, "Diseño clásico con comodidad urbana", "Zapatillas Urbanas Clásicas"),
                    new Producto(2, cat1, marca4, 15, 75.0, "Estilo retro para el día a día", "Zapatillas Retro Lifestyle"),
                    new Producto(3, cat2, marca3, 20, 95.0, "Óptimas para entrenamientos de alta intensidad", "Zapatillas de Entrenamiento Pro"),
                    new Producto(4, cat3, marca1, 10, 150.0, "Amortiguación superior para largas distancias", "Zapatillas Running Elite"),
                    new Producto(5, cat2, marca2, 12, 110.0, "Versátiles para el gimnasio y la calle", "Zapatillas Deportivas All-Around"),
                    new Producto(6, cat4, marca4, 18, 105.0, "Ligeras y rápidas para carreras cortas", "Zapatillas Running Speed"),
                    new Producto(7, cat5, marca1, 14, 130.0, "Soporte y estabilidad para deportes de equipo", "Zapatillas Cross-Training"),
                    new Producto(8, cat4, marca2, 10, 90.0, "Comodidad transpirable para uso diario", "Zapatillas Urbanas Ligeras"),
                    new Producto(9, cat3, marca3, 16, 120.0, "Agarre excepcional en superficies variadas", "Zapatillas Running Trail"),
                    new Producto(10, cat2, marca1, 12, 140.0, "Edición especial con tecnología avanzada", "Zapatillas Deportivas Premium")
            );

            productoRepository.saveAll(productos);
            System.out.println("✅ Productos insertados correctamente.");
        } else {
            System.out.println("ℹ️ Los productos ya existen, no se insertaron datos.");
        }
    }
}
