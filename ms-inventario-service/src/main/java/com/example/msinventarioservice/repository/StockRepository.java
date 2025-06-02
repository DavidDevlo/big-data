package com.example.msinventarioservice.repository;

import com.example.msinventarioservice.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock,Integer> {
}
