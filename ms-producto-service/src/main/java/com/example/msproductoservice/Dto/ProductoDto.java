package com.example.msproductoservice.Dto;

import lombok.Data;

@Data
public class ProductoDto {

    private String nombre;
    private String descripcion;
    private double precio;
    private int stockMinimo;
    private Integer marcaId;
    private Integer categoriaId;

    public ProductoDto(String nombre, Integer categoriaId, Integer marcaId, int stockMinimo, double precio, String descripcion) {
        this.nombre = nombre;
        this.categoriaId = categoriaId;
        this.marcaId = marcaId;
        this.stockMinimo = stockMinimo;
        this.precio = precio;
        this.descripcion = descripcion;
    }
    public ProductoDto(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(Integer marcaId) {
        this.marcaId = marcaId;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "ProductoDto{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", stockMinimo=" + stockMinimo +
                ", marcaId=" + marcaId +
                ", categoriaId=" + categoriaId +
                '}';
    }

}
