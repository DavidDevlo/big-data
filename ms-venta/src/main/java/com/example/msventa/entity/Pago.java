package com.example.msventa.entity;

import com.example.msventa.Dto.ClienteDto;
import com.example.msventa.Dto.UsuarioDto;
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

    @ManyToOne
    @JoinColumn(name = "venta_id")
    private Venta venta;

    private LocalDateTime fechaPago;

    private BigDecimal monto;

    private String metodoPago;

    private String estado;

    private String referenciaPago;

    public Pago(Integer id, Venta venta, LocalDateTime fechaPago, BigDecimal monto, String estado, String metodoPago, String referenciaPago) {
        this.id = id;
        this.venta = venta;
        this.fechaPago = fechaPago;
        this.monto = monto;
        this.estado = estado;
        this.metodoPago = metodoPago;
        this.referenciaPago = referenciaPago;
    }
    public Pago() {}
}