package com.example.msclienteservice.service;


import com.example.msclienteservice.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> listar();

    Optional<Cliente> buscar(Integer id);

    Cliente guardar(Cliente categoria);

    Cliente actualizar(Integer id, Cliente cliente);

    void eliminar(Integer id);
}
