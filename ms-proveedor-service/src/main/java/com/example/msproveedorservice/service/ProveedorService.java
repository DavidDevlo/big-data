package com.example.msproveedorservice.service;




import com.example.msproveedorservice.entity.Proveedor;

import java.util.List;
import java.util.Optional;

public interface ProveedorService {
    List<Proveedor> listar();

    Optional<Proveedor> buscar(Integer id);

    Proveedor guardar(Proveedor proveedor);

    Proveedor actualizar(Integer id, Proveedor proveedor);

    void eliminar(Integer id);


}
