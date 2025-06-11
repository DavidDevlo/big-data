package com.example.msventa.entity;

import com.example.msventa.Dto.ClienteDto;
import com.example.msventa.Dto.ProductoDto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Detalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private double precio;
    private int cantidad;
    @ManyToOne
    @JoinColumn(name = "venta_id")
    private Venta venta;
    private Integer productoId;

    @Transient
    private ProductoDto productoDto;

    public Detalle(Integer id, ProductoDto productoDto, Integer productoId, Venta venta, int cantidad, double precio) {
        this.id = id;
        this.productoDto = productoDto;
        this.productoId = productoId;
        this.venta = venta;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    public Detalle() {}
}
