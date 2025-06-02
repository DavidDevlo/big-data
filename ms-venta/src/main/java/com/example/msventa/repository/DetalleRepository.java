package com.example.msventa.repository;

import com.example.msventa.entity.Detalle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleRepository extends JpaRepository<Detalle, Integer> {
}