package com.example.ReactiveMongo.repository;

import com.example.ReactiveMongo.entity.Stock;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface StockRepository extends ReactiveCrudRepository<Stock, String> {
}
