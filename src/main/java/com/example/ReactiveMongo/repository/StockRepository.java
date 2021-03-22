package com.example.ReactiveMongo.repository;

import com.example.ReactiveMongo.entity.IceStockL1;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface StockRepository extends ReactiveMongoRepository<IceStockL1, String> {


    @Tailable
    Flux<IceStockL1> findBySymbol(String symbol);

    //@Tailable
    //Flux<IceStockL1> findAll();

}