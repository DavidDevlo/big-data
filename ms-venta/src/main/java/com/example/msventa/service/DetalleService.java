package com.example.msventa.service;

import com.example.msventa.Dto.DetalleDto;
import com.example.msventa.Dto.PagoDto;
import com.example.msventa.entity.Detalle;
import com.example.msventa.entity.Pago;
import com.example.msventa.entity.Venta;

import java.util.List;
import java.util.Optional;

public interface DetalleService {
    List<Detalle> findAll();
    Detalle findById(int id);
    Detalle Save(DetalleDto dto);
    Detalle update(Detalle detalle);

}
