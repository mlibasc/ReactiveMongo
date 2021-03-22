package com.example.ReactiveMongo.controller;

import com.example.ReactiveMongo.entity.IceStockL1;
import com.example.ReactiveMongo.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class ReactiveStockController {


    @Autowired
    private final StockRepository stockRepo;

    @GetMapping(value = "/allStocks", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<IceStockL1> stocks(){
        log.info("Stocks BEGIN");
        stockRepo.count().subscribe(result -> log.info("Records: {}", result));
        Flux<IceStockL1> all = stockRepo.findAll();
        log.info("Stocks END");
        return all.delayElements(Duration.ofMillis(100));

    }

    @GetMapping(value = "/stocks/{symbol}", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<IceStockL1> getOneStock(@PathVariable("symbol") String symbol){
        return this.stockRepo.findBySymbol(symbol)
                .repeatWhen(flux -> flux.delayElements(Duration.ofSeconds(1)))
                .subscribeOn(Schedulers.boundedElastic());
    }
}
