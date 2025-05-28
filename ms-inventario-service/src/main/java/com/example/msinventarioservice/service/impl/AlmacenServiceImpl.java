package com.example.msinventarioservice.service.impl;


import com.example.msinventarioservice.entity.Almacen;
import com.example.msinventarioservice.repository.AlmacenRepository;
import com.example.msinventarioservice.service.AlmacenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlmacenServiceImpl implements AlmacenService {


    @Autowired
    private AlmacenRepository almacenRepository;

    @Override
    public List<Almacen> listar() {
        return almacenRepository.findAll();
    }

    @Override
    public Optional<Almacen> buscar(Integer id) {
        return almacenRepository.findById(id);
    }

    @Override
    public Almacen guardar(Almacen almacen) {
        return almacenRepository.save(almacen);
    }

    @Override
    public Almacen actualizar(Integer id, Almacen almacen) {
        almacen.setId(id);
        return almacenRepository.save(almacen);
    }

    @Override
    public void eliminar(Integer id) {
        almacenRepository.deleteById(id);
    }
}


