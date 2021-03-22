package com.example.ReactiveMongo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document
public class Stock {

    @Id
    private String id;
    private String symbol;  		//  13 symbol
    private String price;			//  19  price

    public Stock(String symbol, String price) {
        this.symbol = symbol;
        this.price = price;
    }

}
