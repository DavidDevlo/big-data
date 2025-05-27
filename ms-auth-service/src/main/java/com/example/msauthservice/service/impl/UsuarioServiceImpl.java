package com.example.msauthservice.service.impl;


import com.example.msauthservice.service.UsuarioService;
import com.example.msauthservice.entity.Rol;
import com.example.msauthservice.entity.Usuario;
import com.example.msauthservice.repository.RolRepository;
import com.example.msauthservice.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> buscar(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        // Asegurar que los roles existan
        List<Rol> roles = rolRepository.findAllById(
                usuario.getRoles().stream().map(Rol::getId).toList()
        );
        usuario.setRoles(roles);

        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizar(Integer id, Usuario usuarioActualizado) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuarioExistente.setUsername(usuarioActualizado.getUsername());
        usuarioExistente.setEmail(usuarioActualizado.getEmail());
        usuarioExistente.setPassword(usuarioActualizado.getPassword());
        usuarioExistente.setActivo(usuarioActualizado.getActivo());

        List<Rol> roles = rolRepository.findAllById(
                usuarioActualizado.getRoles().stream().map(Rol::getId).toList()
        );
        usuarioExistente.setRoles(roles);

        return usuarioRepository.save(usuarioExistente);
    }

    @Override
    public void eliminar(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
