package com.example.msventa.Dto;

import com.example.msventa.entity.Detalle;
import com.example.msventa.entity.Factura;
import com.example.msventa.entity.Venta;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class VentaResponseDTO {
    private Integer ventaId;
    private LocalDateTime fechaVenta;
    private Double total;
    private String metodoPago;
    private String estado;

    private ClienteDto cliente;
    private UsuarioDto usuario;

    private List<DetalleDto> detalles;
    private FacturaDto factura;


    public VentaResponseDTO(Integer ventaId, LocalDateTime fechaVenta, Double total, String metodoPago, String estado, ClienteDto cliente, UsuarioDto usuario, List<DetalleDto> detalles, FacturaDto factura) {
        this.ventaId = ventaId;
        this.fechaVenta = fechaVenta;
        this.total = total;
        this.metodoPago = metodoPago;
        this.estado = estado;
        this.cliente = cliente;
        this.usuario = usuario;
        this.detalles = detalles;
        this.factura = factura;
    }

    public VentaResponseDTO(Venta venta, List<Detalle> detalles, Factura factura) {
        this.ventaId = venta.getId();
        this.fechaVenta = venta.getFechaVenta();
        this.total = total;
        this.metodoPago = venta.getMetodoPago();
        this.estado = venta.getEstado();

        // Si tienes métodos de conversión de entidad a DTO, úsalos
        this.cliente = cliente;
        this.usuario = usuario;

        this.detalles = detalles.stream()
                .map(DetalleDto::new)
                .toList();
        this.factura = new FacturaDto(factura);
    }


}
