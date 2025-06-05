package com.example.msventa.Dto;

import lombok.Data;

import java.util.List;

@Data
public class UsuarioDto {
    private Integer id;
    private String username;
    private String email;
    private String password;
    private Boolean activo;
}
