package com.example.msventa.Dto;


import lombok.Data;

@Data
public class ProductoDto {

    private Integer id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stockMinimo;

}
