package com.example.msinventarioservice.Util;


import com.example.msinventarioservice.entity.Almacen;
import com.example.msinventarioservice.repository.AlmacenRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlmacenSeeder implements CommandLineRunner {

    private final AlmacenRepository almacenRepository;

    public AlmacenSeeder(AlmacenRepository almacenRepository) {
        this.almacenRepository = almacenRepository;
    }

    @Override
    public void run(String... args) {
        // Verifica si ya existen datos en la tabla Almacen
        if (almacenRepository.count() == 0) {
            List<Almacen> almacenes = List.of(
                    new Almacen(null, "Av. Los Rosales 101, San Juan", "Almacén Principal San Juan"),
                    new Almacen(null, "Jr. La Luna 202, Miraflores", "Almacén Miraflores Centro"),
                    new Almacen(null, "Calle El Sol 303, Barranco", "Almacén Barranco Sur"),
                    new Almacen(null, "Psje. Las Estrellas 404, Surco", "Almacén Surco Norte"),
                    new Almacen(null, "Av. Las Flores 505, La Molina", "Almacén La Molina Este"),
                    new Almacen(null, "Jr. Los Pinos 606, Magdalena", "Almacén Magdalena Oeste"),
                    new Almacen(null, "Calle Los Sauces 707, Pueblo Libre", "Almacén Pueblo Libre Central"),
                    new Almacen(null, "Av. Los Cedros 808, Lince", "Almacén Lince Norte"),
                    new Almacen(null, "Jr. Los Robles 909, Jesús María", "Almacén Jesús María Sur"),
                    new Almacen(null, "Psje. Las Palmeras 1010, San Isidro", "Almacén San Isidro Principal")
            );
            almacenRepository.saveAll(almacenes);
            System.out.println("✅ Almacenes insertados correctamente.");
        } else {
            System.out.println("ℹ️ Los almacenes ya existen, no se insertaron datos.");
        }
    }
}