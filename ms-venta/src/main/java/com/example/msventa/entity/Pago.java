package com.example.msventa.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "venta_id")
    private Venta venta;

    private LocalDateTime fechaPago;

    private BigDecimal monto;

    private String metodoPago;

    private String estado;

    private String referenciaPago;


}