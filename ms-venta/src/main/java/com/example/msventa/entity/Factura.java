package com.example.msventa.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "venta_id")
    private Venta venta;

    private String numeroFactura;
    private LocalDateTime fechaEmision;
    private String estado;

    public Factura(Integer id, String estado, LocalDateTime fechaEmision, String numeroFactura, Venta venta) {
        this.id = id;
        this.estado = estado;
        this.fechaEmision = fechaEmision;
        this.numeroFactura = numeroFactura;
        this.venta = venta;
    }
    public Factura() {}
}
