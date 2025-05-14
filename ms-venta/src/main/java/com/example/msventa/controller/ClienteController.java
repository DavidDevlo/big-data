package com.example.msventa.controller;



import com.example.msventa.entity.Venta;
import com.example.msventa.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venta")
public class ClienteController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public List<Venta> findAll() {
        return ventaService.findAll();
    }

    @GetMapping("/{id}")
    public Venta findById(@PathVariable int id) {
        return ventaService.findById(id);
    }

    @PostMapping
    public Venta create(@RequestBody Venta venta) {
        return ventaService.Save(venta);
    }

    @PutMapping
    public Venta update(@RequestBody Venta venta) {
        return ventaService.update(venta);
    }
}