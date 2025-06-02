package com.example.msinventarioservice.Dto;


import lombok.Data;

@Data
public class ProductoDto {

    private Integer id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stockMinimo;

    public ProductoDto(Integer id, int stockMinimo, double precio, String descripcion, String nombre) {
        this.id = id;
        this.stockMinimo = stockMinimo;
        this.precio = precio;
        this.descripcion = descripcion;
        this.nombre = nombre;
    }
    public ProductoDto(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
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
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", stockMinimo=" + stockMinimo +
                '}';
    }
}
