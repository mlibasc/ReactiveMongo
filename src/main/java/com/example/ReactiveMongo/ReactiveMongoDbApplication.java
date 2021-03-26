package com.example.ReactiveMongo;

import com.example.ReactiveMongo.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class ReactiveMongoDbApplication {
	public static void main(String[] args) {
		SpringApplication.run(ReactiveMongoDbApplication.class, args);
	}
}
