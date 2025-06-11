package com.example.msventa.service;


import com.example.msventa.Dto.PagoDto;
import com.example.msventa.entity.Pago;
import com.example.msventa.entity.Venta;

import java.util.List;
import java.util.Optional;

public interface PagoService {

    List<Pago> listar();

    Optional<Pago> buscar(Integer id);

    Pago crearPago(PagoDto dto);

    Pago actualizar(Integer id, Pago pago);

    void eliminar(Integer id);

    void registrarPago(PagoDto pagoDto);


}
