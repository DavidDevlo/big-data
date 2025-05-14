package com.example.msauthservice.service.impl;

import com.example.msauthservice.entity.Rol;
import com.example.msauthservice.repository.RolRepository;
import com.example.msauthservice.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl  implements RolService {

    @Autowired
    private RolRepository rolRepository;
    @Override
    public List<Rol> listar() {
        return rolRepository.findAll();
    }

    @Override
    public Optional<Rol> buscar(Integer id) {
        return rolRepository.findById(id);
    }

    @Override
    public Rol guardar(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Rol actualizar(Integer id, Rol rol) {
        rol.setId(id);
        return rolRepository.save(rol);
    }

    @Override
    public void eliminar(Integer id) {
        rolRepository.deleteById(id);
    }
}


