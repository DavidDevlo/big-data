package com.example.msinventarioservice.service;

import com.example.msinventarioservice.Dto.ProductoStockInfoDTO;
import com.example.msinventarioservice.Dto.StockDto;
import com.example.msinventarioservice.entity.Almacen;
import com.example.msinventarioservice.entity.Stock;

import java.util.List;
import java.util.Optional;

public interface StockService {
    List<Stock> findAll();
    Stock findById(int id);
    Stock Save(StockDto dto);
    Stock update(Stock stock);
    void delete(Integer id);
    void descontarStock(Integer id, Integer cantidad);
    List<ProductoStockInfoDTO> listarProductosConStock();



}
