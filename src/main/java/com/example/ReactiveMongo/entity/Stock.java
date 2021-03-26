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
@Document(collection="stocks")
public class Stock {

    @Id
    private String id;
    private String symbol;
    private String price;
    private String bid;
    private String ask;

}
