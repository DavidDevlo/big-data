package com.example.msauthservice.service;

import com.example.msauthservice.entity.Rol;

import java.util.List;
import java.util.Optional;

public interface RolService {
    List<Rol> listar();

    Optional<Rol> buscar(Integer id);

    Rol guardar(Rol categoria);

    Rol actualizar(Integer id, Rol rol);

    void eliminar(Integer id);
}
