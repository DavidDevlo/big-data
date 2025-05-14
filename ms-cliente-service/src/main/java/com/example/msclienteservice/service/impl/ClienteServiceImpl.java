package com.example.msclienteservice.service.impl;

import com.example.msclienteservice.entity.Cliente;
import com.example.msclienteservice.repository.ClienteRepository;
import com.example.msclienteservice.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Override
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> buscar(Integer id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente actualizar(Integer id, Cliente cliente) {
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }

    @Override
    public void eliminar(Integer id) {
        clienteRepository.deleteById(id);
    }
}


