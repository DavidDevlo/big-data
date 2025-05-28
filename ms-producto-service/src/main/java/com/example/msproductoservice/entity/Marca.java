package com.example.msproductoservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Marca{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
    public Marca() {

    }

    public Marca(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
