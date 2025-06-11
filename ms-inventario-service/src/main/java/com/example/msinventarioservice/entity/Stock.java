package com.example.msinventarioservice.entity;

import com.example.msinventarioservice.Dto.ProductoDto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int cantidad;

    @OneToOne
    @JoinColumn(name = "alamcen_id")
    private Almacen almacen;

    private Integer productoId;

    @Transient
    private ProductoDto productoDto;

    public Stock(Integer id, int cantidad, ProductoDto productoDto, Almacen almacen, Integer productoId) {
        this.id = id;
        this.cantidad = cantidad;
        this.productoDto = productoDto;
        this.almacen = almacen;
        this.productoId = productoId;
    }
    public Stock() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public ProductoDto getProductoDto() {
        return productoDto;
    }

    public void setProductoDto(ProductoDto productoDto) {
        this.productoDto = productoDto;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                ", almacen=" + almacen +
                ", productoId=" + productoId +
                ", productoDto=" + productoDto +
                '}';
    }
}
