package com.example.msventa.Dto;

import com.example.msventa.entity.Detalle;
import com.example.msventa.entity.Venta;
import lombok.Data;

@Data
public class DetalleDto {
    private Integer venta;
    private double precio;
    private int cantidad;

    public DetalleDto(Integer venta, double precio, int cantidad) {
        this.venta = venta;
        this.precio = precio;
        this.cantidad = cantidad;
    }


    public DetalleDto(Detalle detalle) {
        this.precio = detalle.getPrecio();
        this.cantidad = detalle.getCantidad();
    }

    public Integer getVenta() {
        return venta;
    }

    public void setVenta(Integer venta) {
        this.venta = venta;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
