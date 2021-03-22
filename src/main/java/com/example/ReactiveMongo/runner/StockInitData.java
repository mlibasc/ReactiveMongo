/*package com.example.ReactiveMongo.runner;

import com.example.ReactiveMongo.entity.IceStockL1;
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
 */
/*
public class StockInitData {

    private final StockRepository stockRepo;
    private final ReactiveMongoTemplate mongoTemplate;

    @PostConstruct
    void initStocksWithTemplate(){

        log.info("initStocks BEGIN");
        stockRepo.count().subscribe(result -> log.info("Records: {}", result));
        Mono<Void> deleteMono = stockRepo.deleteAll();
        deleteMono.subscribe();
        List<IceStockL1> stocks = new ArrayList<>();

        for(int i = 0; i < 15; i++){
            stocks.add(new IceStockL1("symbol" + i,
                    Integer.toString(Math.abs(new Random().nextInt()%10000)),
                    Integer.toString(Math.abs(new Random().nextInt()%10000)),
                    Integer.toString(Math.abs(new Random().nextInt()%10000)),
                    Integer.toString(Math.abs(new Random().nextInt()%10000)),
                    Integer.toString(Math.abs(new Random().nextInt()%10000)),
                    Integer.toString(Math.abs(new Random().nextInt()%10000)),
                    Integer.toString(Math.abs(new Random().nextInt()%10000)),
                    Integer.toString(Math.abs(new Random().nextInt()%10000)),
                    Integer.toString(Math.abs(new Random().nextInt()%10000)),
                    Integer.toString(Math.abs(new Random().nextInt()%10000))));
        }

        Flux<IceStockL1> stockFlux = mongoTemplate.insertAll(stocks);
        stockFlux.subscribe();

        log.info("initStocks END");

    }

    @PostConstruct
    void initStocks(){
        log.info("initStocks BEGIN");
        Mono<Void> deleteMono = stockRepo.deleteAll();
        deleteMono.subscribe();
        List<IceStockL1> stocks = new ArrayList<>();

        for(int i = 0; i < 15; i++){
            stocks.add(new IceStockL1("symbol" + i,
                    Integer.toString(Math.abs(new Random().nextInt()%10000)),
                    Integer.toString(Math.abs(new Random().nextInt()%10000)),
                    Integer.toString(Math.abs(new Random().nextInt()%10000)),
                    Integer.toString(Math.abs(new Random().nextInt()%10000)),
                    Integer.toString(Math.abs(new Random().nextInt()%10000)),
                    Integer.toString(Math.abs(new Random().nextInt()%10000)),
                    Integer.toString(Math.abs(new Random().nextInt()%10000)),
                    Integer.toString(Math.abs(new Random().nextInt()%10000)),
                    Integer.toString(Math.abs(new Random().nextInt()%10000)),
                    Integer.toString(Math.abs(new Random().nextInt()%10000))));
        }

        Flux<IceStockL1> stockFlux = stockRepo.saveAll(stocks);
        stockFlux.subscribe();

        initStocksWithTemplate();

        log.info("initStocks END");

    }

}
 */
/*

        log.info("initStocks BEGIN");
        Mono<Void> deleteMono = stockRepo.deleteAll();
        deleteMono.subscribe();
        List<IceStockL1> stocks = new ArrayList<>();
        for(int i = 0; i < 15; i++){
            stocks.add(new IceStockL1("reactivetemplate" + i,
                    Integer.toString(Math.abs(new Random().nextInt()%10000)),
                    Integer.toString(Math.abs(new Random().nextInt()%10000)),
                    Integer.toString(Math.abs(new Random().nextInt()%10000)),
                    Integer.toString(Math.abs(new Random().nextInt()%10000)),
                    Integer.toString(Math.abs(new Random().nextInt()%10000)),
                    Integer.toString(Math.abs(new Random().nextInt()%10000)),
                    Integer.toString(Math.abs(new Random().nextInt()%10000)),
                    Integer.toString(Math.abs(new Random().nextInt()%10000)),
                    Integer.toString(Math.abs(new Random().nextInt()%10000)),
                    Integer.toString(Math.abs(new Random().nextInt()%1000))));
        }
        Flux<IceStockL1> stockFlux = mongoTemplate.insertAll(stocks);
        stockFlux.subscribe();
        log.info("initStocks END");
 */
