package com.example.msventa.Dto;

import com.example.msventa.entity.Factura;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FacturaDto {
    private Integer venta;
    private String numeroFactura;
    private LocalDateTime fechaEmision;
    private String estado;



    public FacturaDto(Integer venta, String numeroFactura, LocalDateTime fechaEmision, String estado) {
        this.venta = venta;
        this.numeroFactura = numeroFactura;
        this.fechaEmision = fechaEmision;
        this.estado = estado;
    }
    public FacturaDto(Factura factura) {
        this.numeroFactura = factura.getNumeroFactura();
        this.fechaEmision = factura.getFechaEmision();
        this.estado = factura.getEstado();
    }
}
