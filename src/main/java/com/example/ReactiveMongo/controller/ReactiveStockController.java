package com.example.ReactiveMongo.controller;

import com.example.ReactiveMongo.entity.Stock;
import com.example.ReactiveMongo.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ReactiveStockController {

    private final StockRepository stockRepo;

    @GetMapping(value = "/api/stocks", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Stock> stocks(){
        log.info("Stocks BEGIN");
        stockRepo.count().subscribe(result -> log.info("Records: {}", result));
        Flux<Stock> all = stockRepo.findAll();
        log.info("Stocks END");
        return all.delayElements(Duration.ofMillis(500));

    }
}
