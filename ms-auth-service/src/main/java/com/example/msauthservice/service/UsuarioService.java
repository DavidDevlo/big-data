package com.example.msauthservice.service;
import com.example.msauthservice.entity.Rol;
import com.example.msauthservice.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<Usuario> listar();

    Optional<Usuario> buscar(Integer id);

    Usuario guardar(Usuario categoria);

    Usuario actualizar(Integer id, Usuario usuario);

    void eliminar(Integer id);
}
