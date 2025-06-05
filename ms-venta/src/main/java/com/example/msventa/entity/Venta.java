package com.example.msventa.entity;

import com.example.msventa.Dto.ClienteDto;
import com.example.msventa.Dto.UsuarioDto;
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
    private Integer usuarioId;
    @Transient
    private ClienteDto clienteDto;
    @Transient
    private UsuarioDto usuarioDto;

    public Venta(Integer id, LocalDateTime fechaVenta, String metodoPago, BigDecimal total, String estado, Integer clienteId, ClienteDto clienteDto, Integer usuarioId, UsuarioDto usuarioDto) {
        this.id = id;
        this.fechaVenta = fechaVenta;
        this.metodoPago = metodoPago;
        this.total = total;
        this.estado = estado;
        this.clienteId = clienteId;
        this.clienteDto = clienteDto;
        this.usuarioId = usuarioId;
        this.usuarioDto = usuarioDto;
    }
    public Venta() {}
}
