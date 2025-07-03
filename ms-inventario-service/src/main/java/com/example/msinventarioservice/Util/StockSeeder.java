package com.example.msinventarioservice.Util;

import com.example.msinventarioservice.entity.Almacen;
import com.example.msinventarioservice.entity.Stock;
import com.example.msinventarioservice.repository.AlmacenRepository;
import com.example.msinventarioservice.repository.StockRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StockSeeder implements CommandLineRunner {

    private final StockRepository stockRepository;
    private final AlmacenRepository almacenRepository;

    public StockSeeder(StockRepository stockRepository, AlmacenRepository almacenRepository) {
        this.stockRepository = stockRepository;
        this.almacenRepository = almacenRepository;
    }

    @Override
    public void run(String... args) {
        if (stockRepository.count() == 0) {
            // Obtener algunos almacenes existentes (por ID)
            Optional<Almacen> almacen1 = almacenRepository.findById(1);
            Optional<Almacen> almacen2 = almacenRepository.findById(2);
            Optional<Almacen> almacen3 = almacenRepository.findById(3);
            Optional<Almacen> almacen4 = almacenRepository.findById(4);
            Optional<Almacen> almacen5 = almacenRepository.findById(5);
            Optional<Almacen> almacen6 = almacenRepository.findById(6);
            Optional<Almacen> almacen7 = almacenRepository.findById(7);
            Optional<Almacen> almacen8 = almacenRepository.findById(8);
            Optional<Almacen> almacen9 = almacenRepository.findById(9);
            Optional<Almacen> almacen10 = almacenRepository.findById(10);



            if (almacen1.isPresent() && almacen2.isPresent()) {
                List<Stock> stocks = List.of(
                        new Stock(null, 234, almacen1.get(), 1),
                        new Stock(null, 120, almacen2.get(), 2),
                        new Stock(null, 500, almacen3.get(), 3),
                        new Stock(null, 75, almacen4.get(), 4),
                        new Stock(null, 600, almacen5.get(), 5),
                        new Stock(null, 75, almacen6.get(), 6),
                        new Stock(null, 75, almacen7.get(), 7),
                        new Stock(null, 75, almacen8.get(), 8),
                        new Stock(null, 75, almacen9.get(), 9),
                        new Stock(null, 75, almacen10.get(), 10)

                );

                stockRepository.saveAll(stocks);
                System.out.println("✅ Stocks insertados correctamente.");
            } else {
                System.out.println("⚠️ No se encontraron los almacenes con ID 1 y/o 2.");
            }
        } else {
            System.out.println("ℹ️ Los stocks ya existen, no se insertaron datos.");
        }
    }
}
