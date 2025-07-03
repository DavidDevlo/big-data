package com.example.msinventarioservice.Dto;

import java.math.BigDecimal;

public class ProductoStockInfoDTO {
    private Integer productoId;
    private String nombreProducto;
    private BigDecimal precio;
    private Integer cantidad;
    private String nombreAlmacen;

    public ProductoStockInfoDTO(Integer productoId, String nombreProducto, BigDecimal precio, Integer cantidad, String nombreAlmacen) {
        this.productoId = productoId;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.nombreAlmacen = nombreAlmacen;
    }

    public ProductoStockInfoDTO() {}

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombreAlmacen() {
        return nombreAlmacen;
    }

    public void setNombreAlmacen(String nombreAlmacen) {
        this.nombreAlmacen = nombreAlmacen;
    }

    @Override
    public String toString() {
        return "ProductoStockInfoDTO{" +
                "productoId=" + productoId +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                ", nombreAlmacen='" + nombreAlmacen + '\'' +
                '}';
    }
}
