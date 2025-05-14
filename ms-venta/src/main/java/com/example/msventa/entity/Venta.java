package com.example.msventa.entity;

import com.example.msventa.Dto.ClienteDto;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime fechaVenta;
    private BigDecimal total;
    private String metodoPago;
    private String estado;

    private Integer clienteId;
    @Transient
    private ClienteDto clienteDto;



}
