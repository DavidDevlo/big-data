package com.example.msinventarioservice.repository;




import com.example.msinventarioservice.entity.Almacen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlmacenRepository extends JpaRepository<Almacen, Integer> {
}
