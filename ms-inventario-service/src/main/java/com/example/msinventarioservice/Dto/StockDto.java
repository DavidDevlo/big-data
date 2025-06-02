package com.example.msinventarioservice.Dto;

import lombok.Data;

@Data
public class StockDto {
    private Integer almacen;
    private int cantidad;

    public StockDto(int cantidad, Integer almacen) {
        this.cantidad = cantidad;
        this.almacen = almacen;
    }
    public StockDto() {}

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Integer almacen) {
        this.almacen = almacen;
    }

    @Override
    public String toString() {
        return "StockDto{" +
                "almacen=" + almacen +
                ", cantidad=" + cantidad +
                '}';
    }
}
