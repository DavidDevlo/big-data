package com.example.msventa.feing;

import com.example.msventa.Dto.ClienteDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-cliente-service", path = "/cliente")
public interface ClienteFeing {

    @GetMapping("/{id}")
    @CircuitBreaker(name = "clienteListarPorIdCB", fallbackMethod = "fallbackClienteListarPorIdCB")
    public ResponseEntity<ClienteDto> buscarCLiente(@PathVariable Integer id);
    default ResponseEntity<ClienteDto> fallbackClienteListarPorIdCB(Integer id, Exception e) {
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setNombre("Servicio no disponible de cliente");
        clienteDto.setDni("Servicio no disponible de cliente");
        clienteDto.setDireccion("Servicio no disponible de cliente");
        return ResponseEntity.ok(clienteDto);
    }


}