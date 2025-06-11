package com.example.msventa.service.impl;

import com.example.msventa.Dto.FacturaDto;
import com.example.msventa.entity.Factura;
import com.example.msventa.entity.Venta;
import com.example.msventa.feing.ClienteFeing;
import com.example.msventa.feing.UsuarioFeing;
import com.example.msventa.repository.FacturaRepository;
import com.example.msventa.repository.VentaRepository;
import com.example.msventa.service.FacturaService;
import com.example.msventa.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FacturaServiceImpl implements FacturaService {
    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private VentaService ventaService;
    @Autowired
    private ClienteFeing clienteFeing;
    @Autowired
    private UsuarioFeing usuarioFeing;

    @Override
    public List<Factura> listar() {
        List<Factura> facturas = facturaRepository.findAll();

        for (Factura factura : facturas) {
            Venta ventaCompleta = ventaService.findById(factura.getVenta().getId());
            factura.setVenta(ventaCompleta);
        }

        return facturas;
    }

    @Override
    public Optional<Factura> buscar(Integer id) {
        return facturaRepository.findById(id);
    }

    @Override
    public Factura crearFactura(FacturaDto dto) {
        Venta venta = ventaRepository.findById(dto.getVenta())
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));

        Factura factura = new Factura();
        factura.setVenta(venta);
        factura.setFechaEmision(dto.getFechaEmision());
        factura.setNumeroFactura(dto.getNumeroFactura());
        factura.setEstado(dto.getEstado());
        return facturaRepository.save(factura);
    }

    @Override
    public Factura actualizar(Integer id, Factura factura) {
        Optional<Factura> op = facturaRepository.findById(id);
        if (op.isPresent()) {
            Factura facturaExistente = op.get();

            facturaExistente.setVenta(factura.getVenta());
            facturaExistente.setFechaEmision(factura.getFechaEmision());
            facturaExistente.setNumeroFactura(factura.getNumeroFactura());
            facturaExistente.setEstado(factura.getEstado());

            return facturaRepository.save(facturaExistente);
        }
        return null; // o lanzar excepción
    }

    @Override
    public void eliminar(Integer id) {
        facturaRepository.deleteById(id);
    }


}
