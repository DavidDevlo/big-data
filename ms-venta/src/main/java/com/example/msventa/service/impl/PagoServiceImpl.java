package com.example.msventa.service.impl;

import com.example.msventa.entity.Pago;
import com.example.msventa.repository.PagoRepository;
import com.example.msventa.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoServiceImpl implements PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    @Override
    public List<Pago> listar() {
        return pagoRepository.findAll();
    }

    @Override
    public Optional<Pago> buscar(Integer id) {
        return pagoRepository.findById(id);
    }

    @Override
    public Pago guardar(Pago pago) {
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
