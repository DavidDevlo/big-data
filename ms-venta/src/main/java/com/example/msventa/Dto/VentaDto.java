package com.example.msventa.Dto;


import lombok.Data;


import java.time.LocalDateTime;
@Data
public class VentaDto {
    private Integer id;
    private LocalDateTime fechaVenta;
    private Double total;
    private String metodoPago;
    private String estado;
    private Long clienteId;
    private Long usuarioId;
    private ClienteDto clienteDto;
    private UsuarioDto usuarioDto;

}
