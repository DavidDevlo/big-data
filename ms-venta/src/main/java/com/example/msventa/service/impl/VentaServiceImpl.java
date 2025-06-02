package com.example.msventa.service.impl;


import com.example.msventa.entity.Venta;
import com.example.msventa.feing.ClienteFeing;
import com.example.msventa.feing.UsuarioFeing;
import com.example.msventa.repository.VentaRepository;
import com.example.msventa.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    private ClienteFeing clienteFeing;
    @Autowired
    private UsuarioFeing usuarioFeing;

    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public List<Venta> findAll() {

        List<Venta> ventas = ventaRepository.findAll();
        for (Venta venta : ventas) {
            venta.setClienteDto(clienteFeing.buscarCLiente(venta.getClienteId()).getBody());
            venta.setUsuarioDto(usuarioFeing.buscarUsuario(venta.getUsuarioId()).getBody());

        }
        return ventas;
    }

    @Override
    public Venta findById(int id) {
        Venta venta = ventaRepository.findById(id).get();
        venta.setClienteDto(clienteFeing.buscarCLiente(venta.getClienteId()).getBody());
        venta.setUsuarioDto(usuarioFeing.buscarUsuario(venta.getClienteId()).getBody());
        return ventaRepository.findById(id).get();
    }

    @Override
    public Venta Save(Venta venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public Venta update(Venta venta) {
        return ventaRepository.save(venta);
    }

}


