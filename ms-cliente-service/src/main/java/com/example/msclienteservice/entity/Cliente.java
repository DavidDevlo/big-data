package com.example.msclienteservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;


    private String nombre;


    @Column(unique = true, length = 10)
    private String dni;

    @Email
    @Column(unique = true)
    private String email;

    private String telefono;

    private String direccion;

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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Cliente(String direccion, String telefono, String email, String nombre, String dni, Integer id) {
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.nombre = nombre;
        this.dni = dni;
        this.id = id;
    }
    public Cliente(){}

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
