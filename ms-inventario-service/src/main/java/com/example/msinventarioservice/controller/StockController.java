package com.example.msinventarioservice.controller;

import com.example.msinventarioservice.Dto.StockDto;
import com.example.msinventarioservice.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.msinventarioservice.entity.Stock;
import com.example.msinventarioservice.service.AlmacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping
    public List<Stock> findAll() {
        return stockService.findAll();
    }

    @GetMapping("/{id}")
    public Stock findById(@PathVariable int id) {
        return stockService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Stock> create(@RequestBody StockDto dto) {
        Stock nuevaDetalle = stockService.Save(dto);
        return ResponseEntity.ok(nuevaDetalle);
    }

    @PutMapping
    public Stock update(@RequestBody Stock stock) {
        return stockService.update(stock);
    }
}
