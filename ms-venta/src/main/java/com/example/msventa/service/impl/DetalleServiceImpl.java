package com.example.msventa.service.impl;

import com.example.msventa.Dto.DetalleDto;
import com.example.msventa.entity.Detalle;
import com.example.msventa.entity.Factura;
import com.example.msventa.entity.Venta;
import com.example.msventa.feing.ProductoFeing;
import com.example.msventa.repository.DetalleRepository;
import com.example.msventa.repository.VentaRepository;
import com.example.msventa.service.DetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleServiceImpl implements DetalleService {
    @Autowired
    private ProductoFeing productoFeing;


    @Autowired
    private DetalleRepository detalleRepository;
    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public List<Detalle> findAll() {
        return detalleRepository.findAll();
    }

    @Override
    public Detalle findById(int id) {
        Detalle detalle = detalleRepository.findById(id).get();
        detalle.setProductoDto(productoFeing.buscarDetalle(detalle.getProductoId()).getBody());
        return detalleRepository.findById(id).get();
    }

    @Override
    public Detalle Save(DetalleDto dto) {
        Venta venta = ventaRepository.findById(dto.getVenta())
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));

        Detalle detalle = new Detalle();
        detalle.setVenta(venta);
        detalle.setCantidad(dto.getCantidad());
        detalle.setPrecio(dto.getPrecio());
        return detalleRepository.save(detalle);
    }

    @Override
    public Detalle update(Detalle detalle) {
        return detalleRepository.save(detalle);
    }
}
