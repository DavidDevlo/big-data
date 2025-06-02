package com.example.msventa.Dto;

import com.example.msventa.entity.Venta;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FacturaDto {
    private Integer venta;
    private String numeroFactura;
    private LocalDateTime fechaEmision;
    private String estado;
}
