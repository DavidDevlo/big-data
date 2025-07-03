package com.example.msproductoservice.Dto;

import com.example.msproductoservice.entity.Producto;
import lombok.Data;

@Data
public class ProductoDto {

    private Integer id;
    private String imagenUrl;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stockMinimo;
    private Integer marcaId;
    private Integer categoriaId;



    public ProductoDto(String imagenUrl, Integer marcaId, int stockMinimo, String nombre, String descripcion, double precio, Integer categoriaId) {
        this.imagenUrl = imagenUrl;
        this.marcaId = marcaId;
        this.stockMinimo = stockMinimo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoriaId = categoriaId;
    }
    public ProductoDto() {}
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    @Override
    public String toString() {
        return "ProductoDto{" +
                "imagenUrl='" + imagenUrl + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", stockMinimo=" + stockMinimo +
                ", marcaId=" + marcaId +
                ", categoriaId=" + categoriaId +
                '}';
    }


}
