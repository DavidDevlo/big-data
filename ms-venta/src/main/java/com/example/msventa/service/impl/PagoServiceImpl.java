package com.example.msventa.service.impl;

import com.example.msventa.Dto.PagoDto;
import com.example.msventa.entity.Factura;
import com.example.msventa.entity.Pago;
import com.example.msventa.entity.Venta;
import com.example.msventa.repository.PagoRepository;
import com.example.msventa.repository.VentaRepository;
import com.example.msventa.service.PagoService;
import com.example.msventa.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
        List<Pago> pagos     = pagoRepository.findAll();

        for (Pago pago : pagos) {
            Venta ventaCompleta = ventaService.findById(pago.getVenta().getId());
            pago.setVenta(ventaCompleta);
        }
        return pagos;
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

    @Override
    public void registrarPago(PagoDto dto) {
        Venta venta = ventaRepository.findById(dto.getVenta())
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));

        // Convertir el DTO a entidad
        Pago pago = new Pago();
        pago.setVenta(venta);
        pago.setFechaPago(dto.getFechaPago() != null ? dto.getFechaPago() : LocalDateTime.now());
        pago.setMonto(BigDecimal.valueOf(dto.getMonto()));
        pago.setMetodoPago(dto.getMetodoPago());
        pago.setEstado(dto.getEstado());
        pago.setReferenciaPago(dto.getReferenciaPago());

        pagoRepository.save(pago);

        // Verificar el total de pagos realizados para esta venta
        BigDecimal totalPagado = pagoRepository.totalPagadoPorVenta(venta.getId());
        if (totalPagado.compareTo(venta.getTotal()) >= 0) {
            venta.setEstado("Pagado");
            ventaRepository.save(venta);
        }
        }
}
