package com.example.msventa.Dto;

import lombok.Data;

import java.util.List;

@Data
public class VentaRequestDTO {
    private Long clienteId;
    private Long usuarioId;
    private List<DetalleProductoDTO> productos;
    private String metodoPago;
}

