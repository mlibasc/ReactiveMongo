package com.example.ReactiveMongo.repository;

import com.example.ReactiveMongo.entity.Stock;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface StockRepository extends ReactiveMongoRepository<Stock, String> {

    @Tailable
    Flux<Stock> findWithTailableCursorBy();

    @Tailable
    Flux<Stock> findBySymbol(String symbol);

    @Tailable
    @Query("{'symbol': {'$in': ?0}}")
    Flux<Stock> findByDefaultSymbols(List<String> stocks);

}