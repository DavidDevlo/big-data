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
    @OneToOne
    @JoinColumn(name = "venta_id")
    private Venta venta;
    private Integer productoId;

    @Transient
    private ProductoDto productoDto;




}
