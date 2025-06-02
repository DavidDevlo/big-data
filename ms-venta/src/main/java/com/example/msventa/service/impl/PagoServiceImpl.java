package com.example.msventa.service.impl;

import com.example.msventa.Dto.PagoDto;
import com.example.msventa.entity.Pago;
import com.example.msventa.entity.Venta;
import com.example.msventa.repository.PagoRepository;
import com.example.msventa.repository.VentaRepository;
import com.example.msventa.service.PagoService;
import com.example.msventa.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PagoServiceImpl implements PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private VentaRepository ventaRepository;
    @Autowired
    private VentaService ventaService;

    @Override
    public List<Pago> listar() {
        List<Pago> pagos = pagoRepository.findAll();

        return pagos.stream().map(pago -> {
            Long idVenta = Long.valueOf(pago.getVenta().getId());
            Venta ventaConDetalle = ventaService.findById(Math.toIntExact(idVenta)); // ya viene con DTOs

            pago.setVenta(ventaConDetalle); // reemplazas la venta básica por la completa
            return pago;
        }).collect(Collectors.toList());
    }

    @Override
    public Optional<Pago> buscar(Integer id) {
        return pagoRepository.findById(id);
    }

    @Override
    public Pago crearPago(PagoDto dto) {
        Venta venta = ventaRepository.findById(dto.getVenta())
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));

        Pago pago = new Pago();
        pago.setVenta(venta);
        pago.setFechaPago(dto.getFechaPago());
        pago.setMonto(BigDecimal.valueOf(dto.getMonto()));
        pago.setMetodoPago(dto.getMetodoPago());
        pago.setEstado(dto.getEstado());
        pago.setReferenciaPago(dto.getReferenciaPago());

        return pagoRepository.save(pago);
    }

    @Override
    public Pago actualizar(Integer id, Pago pago) {
        Optional<Pago> op = pagoRepository.findById(id);
        if (op.isPresent()) {
            Pago pagoExistente = op.get();

            pagoExistente.setVenta(pago.getVenta());
            pagoExistente.setFechaPago(pago.getFechaPago());
            pagoExistente.setMonto(pago.getMonto());
            pagoExistente.setMetodoPago(pago.getMetodoPago());
            pagoExistente.setEstado(pago.getEstado());
            pagoExistente.setReferenciaPago(pago.getReferenciaPago());

            return pagoRepository.save(pagoExistente);
        }
        return null; // o lanzar excepción
    }

    @Override
    public void eliminar(Integer id) {
        pagoRepository.deleteById(id);
    }
}
