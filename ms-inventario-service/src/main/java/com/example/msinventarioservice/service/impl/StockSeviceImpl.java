package com.example.msinventarioservice.service.impl;

import com.example.msinventarioservice.Dto.StockDto;
import com.example.msinventarioservice.entity.Almacen;
import com.example.msinventarioservice.entity.Stock;
import com.example.msinventarioservice.feing.ProductoFeing;
import com.example.msinventarioservice.repository.AlmacenRepository;
import com.example.msinventarioservice.repository.StockRepository;
import com.example.msinventarioservice.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class StockSeviceImpl implements StockService {
    @Autowired
    private ProductoFeing productoFeing;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private AlmacenRepository almacenRepository;

    @Override
    public List<Stock> findAll() {
        return stockRepository.findAll();
    }

    @Override
    public Stock findById(int id) {
        Stock stock = stockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stock no encontrado"));
        stock.setProductoDto(productoFeing.buscarProducto(stock.getProductoId()).getBody());
        return stock;
    }

    @Override
    public Stock Save(StockDto dto) {
        Almacen almacen = almacenRepository.findById(dto.getAlmacen())
                .orElseThrow(() -> new RuntimeException("Almacén no encontrado"));

        Stock stock = new Stock();

        stock.setAlmacen(almacen);
        stock.setCantidad(dto.getCantidad());

        return stockRepository.save(stock);
    }

    @Override
    public Stock update(Stock stock) {
        if (!stockRepository.existsById(stock.getId())) {
            throw new RuntimeException("Stock no encontrado para actualizar");
        }
        return stockRepository.save(stock);
    }
    @Override
    public void delete(Integer id) {
        stockRepository.deleteById(id);
    }
}
