package com.example.msventa.Dto;

import com.example.msventa.entity.Venta;
import lombok.Data;

@Data
public class DetalleDto {
    private Integer venta;
    private double precio;
    private int cantidad;
}
