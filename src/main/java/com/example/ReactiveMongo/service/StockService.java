package com.example.ReactiveMongo.service;

import com.example.ReactiveMongo.entity.Stock;
import com.example.ReactiveMongo.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepo;

    // Return all stocks that are inserted into the DB with a 100 millisecond delay
    public Flux<Stock> getAllStocks(){
        Flux<Stock> allStocks = stockRepo.findWithTailableCursorBy();
        // Delay stock output by 100 milliseconds to relieve back pressure
        return allStocks.delayElements(Duration.ofMillis(100));
    }

    // Return a specific stock's data with 1 second delay
    public Flux<Stock> getOneStock(String symbol){
        Flux<Stock> oneStock = stockRepo.findBySymbol(symbol);
        return oneStock.delayElements(Duration.ofMillis(1000));
    }

    // Return a Flux of the default stocks with no delay
    public Flux<Stock> getDefaultStocks(List<String> listOfStocks){
        Flux<Stock> defaultStocks = stockRepo.findByDefaultSymbols(listOfStocks);
        return defaultStocks;
    }
}