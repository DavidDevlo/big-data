package com.example.msproductoservice.service.impl;

import com.example.msproductoservice.Dto.ProductoDto;
import com.example.msproductoservice.entity.Categoria;
import com.example.msproductoservice.entity.Producto;
import com.example.msproductoservice.repository.CategoriaRepository;
import com.example.msproductoservice.repository.ProductoRepository;
import com.example.msproductoservice.service.ProductoService;
import org.springframework.stereotype.Service;
import com.example.msproductoservice.entity.Marca;
import com.example.msproductoservice.repository.MarcaRepository;


import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Producto> listar() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> buscar(Integer id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto guardar(ProductoDto dto) {
        Marca marca = marcaRepository.findById(dto.getMarcaId())
                .orElseThrow(() -> new RuntimeException("Marca no encontrada"));

        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));

        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setStockMinimo(dto.getStockMinimo());
        producto.setImagenUrl(dto.getImagenUrl()); //
        producto.setMarca(marca);
        producto.setCategoria(categoria);

        return productoRepository.save(producto);
    }

    @Override
    public Producto actualizar(Integer id, Producto producto) {
        Optional<Producto> op = productoRepository.findById(id);
        if (op.isPresent()) {
            Producto productoExistente = op.get();

            productoExistente.setNombre(producto.getNombre());
            productoExistente.setDescripcion(producto.getDescripcion());
            productoExistente.setPrecio(producto.getPrecio());
            productoExistente.setStockMinimo(producto.getStockMinimo());
            productoExistente.setMarca(producto.getMarca());
            productoExistente.setCategoria(producto.getCategoria());

            return productoRepository.save(productoExistente);
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        productoRepository.deleteById(id);
    }
}