package com.example.msventa.Dto;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PagoDto {
    private Integer ventaId;
    private LocalDateTime fechaPago;
    private BigDecimal monto;
    private String metodoPago;
    private String estado;
    private String referenciaPago;

    // Getters y Setters
}
