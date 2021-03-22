package com.example.ReactiveMongo.repository;

import com.example.ReactiveMongo.entity.Stock;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface StockRepository extends ReactiveMongoRepository<Stock, String> {


    @Tailable
    Flux<Stock> findBySymbol(String symbol);

    //@Tailable
    //Flux<IceStockL1> findAll();

}