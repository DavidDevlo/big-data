package com.example.msventa.service.impl;


import com.example.msventa.Dto.*;
import com.example.msventa.entity.Detalle;
import com.example.msventa.entity.Factura;
import com.example.msventa.entity.Venta;
import com.example.msventa.feing.ClienteFeing;
import com.example.msventa.feing.InventarioFeing;
import com.example.msventa.feing.ProductoFeing;
import com.example.msventa.feing.UsuarioFeing;
import com.example.msventa.repository.DetalleRepository;
import com.example.msventa.repository.FacturaRepository;
import com.example.msventa.repository.VentaRepository;
import com.example.msventa.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    private ClienteFeing clienteFeing;
    @Autowired
    private UsuarioFeing usuarioFeing;
    @Autowired
    private ProductoFeing productoFeing;

    @Autowired
    private InventarioFeing inventarioFeing;

    @Autowired
    private VentaRepository ventaRepository;
    @Autowired
    private DetalleRepository detalleRepository;
    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    public VentaResponseDTO registrarVentaConFactura(VentaRequestDTO request) {

        ClienteDto cliente = clienteFeing.buscarCLiente(Math.toIntExact(request.getClienteId())).getBody();


        UsuarioDto usuario = usuarioFeing.buscarUsuario(Math.toIntExact(request.getUsuarioId())).getBody();

        double total = 0;
        List<Detalle> detalles = new ArrayList<>();


        for (DetalleProductoDTO productoReq : request.getProductos()) {
            ProductoDto producto = productoFeing.buscarDetalle(Math.toIntExact(productoReq.getProductoId())).getBody();

            if (producto.getStockMinimo() < productoReq.getCantidad()) {
                throw new RuntimeException("Stock insuficiente para el producto " + producto.getNombre());
            }

            double subtotal = producto.getPrecio() * productoReq.getCantidad();
            total += subtotal;


            Detalle detalle = new Detalle();
            detalle.setProductoId(Math.toIntExact(productoReq.getProductoId()));
            detalle.setCantidad(productoReq.getCantidad());
            detalle.setPrecio(producto.getPrecio());
            detalles.add(detalle);


            inventarioFeing.descontarStock(Math.toIntExact(productoReq.getProductoId()), productoReq.getCantidad());


        }

        // venta
        Venta venta = new Venta();
        venta.setUsuarioId(Math.toIntExact(request.getUsuarioId()));
        venta.setClienteId(Math.toIntExact(request.getClienteId()));
        venta.setMetodoPago(request.getMetodoPago());
        venta.setFechaVenta(LocalDateTime.now());
        venta.setEstado("Registrada");
        venta.setTotal(BigDecimal.valueOf(total));
        venta = ventaRepository.save(venta);

        //  detalle
        for (Detalle detalle : detalles) {
            detalle.setVenta(venta);
            detalleRepository.save(detalle);
        }

        //  factura
        Factura factura = new Factura();
        factura.setVenta(venta);
        factura.setNumeroFactura("F-" + UUID.randomUUID().toString().substring(0, 8));
        factura.setFechaEmision(LocalDateTime.now());
        factura.setEstado("Emitida");
        factura = facturaRepository.save(factura);

        return new VentaResponseDTO(venta,detalles,factura);
    }


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


