package com.example.msproductoservice.repository;




import com.example.msproductoservice.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Integer> {
    Marca findByNombre(String nombre);
}
