package com.example.ReactiveMongo.runner;

import com.example.ReactiveMongo.entity.Stock;
import com.example.ReactiveMongo.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class StockInitData {

    private final StockRepository stockRepo;
    private final ReactiveMongoTemplate mongoTemplate;

    void initStocksWithTemplate(){

        List<Stock> stocks = new ArrayList<>();
        for(int i = 0; i < 15; i++){
            stocks.add(new Stock("reactivetemplate" + i, Integer.toString(Math.abs(new Random().nextInt()%1000))));
        }
        Flux<Stock> stockFlux = mongoTemplate.insertAll(stocks);
        stockFlux.subscribe();
    }

    @PostConstruct
    void initStocks(){
        log.info("initStocks BEGIN");
        Mono<Void> deleteMono = stockRepo.deleteAll();
        deleteMono.subscribe();
        List<Stock> stocks = new ArrayList<>();

        for(int i = 0; i < 15; i++){
            stocks.add(new Stock("generated" + i, Integer.toString(Math.abs(new Random().nextInt()%1000))));
        }

        Flux<Stock> stockFlux = stockRepo.saveAll(stocks);
        stockFlux.subscribe();

        initStocksWithTemplate();

        log.info("initStocks END");

    }
}
