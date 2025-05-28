package com.example.msproductoservice.service;






import com.example.msproductoservice.entity.Marca;

import java.util.List;
import java.util.Optional;

public interface MarcaService {
    List<Marca> listar();

    Optional<Marca> buscar(Integer id);

    Marca guardar(Marca marca);

    Marca actualizar(Integer id, Marca marca);

    void eliminar(Integer id);


}
