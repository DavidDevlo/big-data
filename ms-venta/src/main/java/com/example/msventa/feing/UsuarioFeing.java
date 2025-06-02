package com.example.msventa.feing;

import com.example.msventa.Dto.UsuarioDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-auth-service", path = "/usuarios")
public interface UsuarioFeing {
    @GetMapping("/{id}")
    @CircuitBreaker(name = "usuarioListarPorIdCB", fallbackMethod = "fallbackUsuarioListarPorIdCB")
    ResponseEntity<UsuarioDto> buscarUsuario(@PathVariable("id") Integer id);

    default ResponseEntity<UsuarioDto> fallbackUsuarioListarPorIdCB(Integer id, Exception e) {
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setId(id);
        usuarioDto.setUsername("Servicio no disponible de usuario");
        usuarioDto.setEmail("Servicio no disponible de usuario");
        usuarioDto.setPassword(null); // o enmascarar si se requiere
        usuarioDto.setActivo(false);
        return ResponseEntity.ok(usuarioDto);
    }


}
