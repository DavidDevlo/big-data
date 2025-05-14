package com.example.msventa.Dto;


import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class ClienteDto {
    private Integer id ;
    private String nombre;
    private String dni;
    @Email
    private String email;
    private String telefono;
    private String direccion;
}
