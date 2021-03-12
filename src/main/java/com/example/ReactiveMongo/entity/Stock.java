package com.example.ReactiveMongo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock {

    @Id
    private String id;
    private String symbol;
    private String price;

    public Stock(String symbol, String price){
        this.symbol = symbol;
        this.price = price;
    }

}
