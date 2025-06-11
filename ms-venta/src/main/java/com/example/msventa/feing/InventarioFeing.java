package com.example.msventa.feing;

import com.example.msventa.Dto.ProductoDto;
import com.example.msventa.Dto.StockDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "ms-inventario-service", path = "/stock")
public interface InventarioFeing {
    @GetMapping("/{id}")
    @CircuitBreaker(name = "productoListarPorIdCB", fallbackMethod = "fallbackProductoListarPorIdCB")
    ResponseEntity<StockDto> buscarDetalle(@PathVariable("id") Integer id);

    // ✅ Nuevo método para descontar stock (agregado)
    @PutMapping("/descontar/{id}/{cantidad}")
    void descontarStock(@PathVariable("id") Integer productoId, @PathVariable("cantidad") Integer cantidad);

    // Fallback
    default ResponseEntity<StockDto> fallbackProductoListarPorIdCB(Integer id, Exception e) {
        StockDto stockDto = new StockDto();
        stockDto.setId(id);
        stockDto.setCantidad(0);
        return ResponseEntity.ok(stockDto);
    }
}