package com.example.msventa.feing;

import com.example.msventa.Dto.ClienteDto;
import com.example.msventa.Dto.ProductoDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-producto-service", path = "/productos")
public interface ProductoFeing {
    @GetMapping("/{id}")
    @CircuitBreaker(name = "productoListarPorIdCB", fallbackMethod = "fallbackProductoListarPorIdCB")
    ResponseEntity<ProductoDto> buscarDetalle(@PathVariable("id") Integer id);


    default ResponseEntity<ProductoDto> fallbackProductoListarPorIdCB(Integer id, Exception e) {

        ProductoDto productoDto = new ProductoDto();
        productoDto.setId(id);
        productoDto.setNombre("Servicio no disponible de producto");
        productoDto.setDescripcion("Servicio no disponible de producto");
        productoDto.setPrecio(0.0);
        productoDto.setStockMinimo(0);


        return ResponseEntity.ok(productoDto);
    }
}
