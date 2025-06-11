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

    public VentaResponseDTO(Venta venta, List<Detalle> detalles, Factura factura) {
    }
}
