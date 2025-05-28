package com.example.msproductoservice.service.impl;


import com.example.msproductoservice.entity.Marca;
import com.example.msproductoservice.repository.MarcaRepository;
import com.example.msproductoservice.service.MarcaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaServiceImpl implements MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;
    @Override
    public List<Marca> listar() {
        return marcaRepository.findAll();
    }

    @Override
    public Optional<Marca> buscar(Integer id) {
        return marcaRepository.findById(id);
    }

    @Override
    public Marca guardar(Marca marca) {
        return marcaRepository.save(marca);
    }

    @Override
    public Marca actualizar(Integer id, Marca marca) {
        marca.setId(id);
        return marcaRepository.save(marca);
    }

    @Override
    public void eliminar(Integer id) {
        marcaRepository.deleteById(id);
    }
}


