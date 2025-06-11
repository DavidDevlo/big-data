package com.example.msinventarioservice.Dto;

import lombok.Data;

@Data
public class StockDto {

    private Integer id;
    private Integer almacen;
    private int cantidad;
    private Integer productoId;

    public StockDto(Integer id, Integer productoId, int cantidad, Integer almacen) {
        this.id = id;
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.almacen = almacen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Integer almacen) {
        this.almacen = almacen;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    @Override
    public String toString() {
        return "StockDto{" +
                "id=" + id +
                ", almacen=" + almacen +
                ", cantidad=" + cantidad +
                ", productoId=" + productoId +
                '}';
    }
}
