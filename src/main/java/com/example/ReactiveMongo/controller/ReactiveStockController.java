package com.example.ReactiveMongo.controller;

import com.example.ReactiveMongo.entity.Stock;
import com.example.ReactiveMongo.repository.StockRepository;
import com.example.ReactiveMongo.service.StockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class ReactiveStockController {

    @Autowired
    private StockService stockService;

    @Autowired
    private StockRepository stockRepo;


    // Output all stocks
    @GetMapping(value = "/allStocks", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Stock> stocks(){
        Flux<Stock> all = stockService.getAllStocks();
        // Delay stock output by 100 milliseconds to relieve back pressure
        return all;
    }

    // Output a specific stock
    @GetMapping(value = "/{symbol}", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Stock> getOneStock(@PathVariable("symbol") String symbol){
        return stockService.getOneStock(symbol);
    }

    // Output a group of stocks
    // AAPL, TSLA, BB, GME
    @GetMapping(value="/getDefaultStocks", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Stock> getDefaultStocks(){
        List<String> listOfStocks = new ArrayList<>();
        listOfStocks.add("AAPL");
        listOfStocks.add("TSLA");
        listOfStocks.add("BB");
        listOfStocks.add("GME");
        return stockService.getDefaultStocks(listOfStocks);
    }


}
