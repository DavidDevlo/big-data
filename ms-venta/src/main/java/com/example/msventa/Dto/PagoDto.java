package com.example.msventa.Dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PagoDto {
    private Integer venta; // Solo el ID de la venta
    private LocalDateTime fechaPago;
    private Double monto;
    private String metodoPago;
    private String estado;
    private String referenciaPago;
}
