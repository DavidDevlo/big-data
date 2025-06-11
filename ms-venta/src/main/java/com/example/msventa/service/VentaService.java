package com.example.msventa.service;




import com.example.msventa.Dto.VentaRequestDTO;
import com.example.msventa.Dto.VentaResponseDTO;
import com.example.msventa.entity.Venta;

import java.util.List;
import java.util.Optional;

public interface VentaService {
    List<Venta> findAll();
    Venta findById(int id);
    Venta Save(Venta venta);
    Venta update(Venta venta);
    VentaResponseDTO registrarVentaConFactura(VentaRequestDTO requestDTO);


}
