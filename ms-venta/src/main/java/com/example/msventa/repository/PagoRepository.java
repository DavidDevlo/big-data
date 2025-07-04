package com.example.msventa.repository;

import com.example.msventa.entity.Pago;
import com.example.msventa.entity.Venta;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface PagoRepository extends JpaRepository<Pago, Integer> {
    @Query("SELECT COALESCE(SUM(p.monto), 0) FROM Pago p WHERE p.venta.id = :ventaId")
    BigDecimal totalPagadoPorVenta(@Param("ventaId") Integer ventaId);

    List<Pago> findByVentaId(Integer ventaId);
}