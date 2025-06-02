package com.example.msventa.service;

import com.example.msventa.Dto.FacturaDto;
import com.example.msventa.Dto.PagoDto;
import com.example.msventa.entity.Factura;
import com.example.msventa.entity.Pago;

import java.util.List;
import java.util.Optional;

public interface FacturaService {
    List<Factura> listar();

    Optional<Factura> buscar(Integer id);


    Factura actualizar(Integer id, Factura factura);

    Factura crearFactura(FacturaDto dto);

    void eliminar(Integer id);


}
