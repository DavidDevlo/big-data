package com.example.msproductoservice.service;

import com.example.msproductoservice.entity.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    List<Categoria> listar();

    Optional<Categoria> buscar(Integer id);

    Categoria guardar(Categoria categoria);

    Categoria actualizar(Integer id, Categoria categoria);

    void eliminar(Integer id);
}
