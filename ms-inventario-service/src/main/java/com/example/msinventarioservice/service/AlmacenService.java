package com.example.msinventarioservice.service;






import com.example.msinventarioservice.entity.Almacen;


import java.util.List;
import java.util.Optional;

public interface AlmacenService {
    List<Almacen> listar();

    Optional<Almacen> buscar(Integer id);

    Almacen guardar(Almacen almacen);

    Almacen actualizar(Integer id, Almacen almacen);

    void eliminar(Integer id);


}
