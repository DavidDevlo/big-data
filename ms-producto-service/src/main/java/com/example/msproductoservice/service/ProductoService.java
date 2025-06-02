package com.example.msproductoservice.service;

import com.example.msproductoservice.Dto.ProductoDto;
import com.example.msproductoservice.entity.Marca;
import com.example.msproductoservice.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<Producto> listar();

    Optional<Producto> buscar(Integer id);

    Producto guardar(ProductoDto dto);

    Producto actualizar(Integer id, Producto producto);

    void eliminar(Integer id);



}
