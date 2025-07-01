package com.example.msventa.entity;

import com.example.msventa.Dto.ClienteDto;
import com.example.msventa.Dto.UsuarioDto;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDateTime fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public ClienteDto getClienteDto() {
        return clienteDto;
    }

    public void setClienteDto(ClienteDto clienteDto) {
        this.clienteDto = clienteDto;
    }

    public UsuarioDto getUsuarioDto() {
        return usuarioDto;
    }

    public void setUsuarioDto(UsuarioDto usuarioDto) {
        this.usuarioDto = usuarioDto;
    }
}
