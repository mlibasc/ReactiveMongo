package com.example.ReactiveMongo;

import com.example.ReactiveMongo.entity.IceStockL1;
import com.example.ReactiveMongo.repository.StockRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class ReactiveMongoDbApplication /*implements CommandLineRunner*/ {

	@Autowired
	private StockRepository stockRepo;

	@Value("classpath:iceStockL1.json")
	private Resource resource;

	public static void main(String[] args) {
		SpringApplication.run(ReactiveMongoDbApplication.class, args);
	}

	/*
	@Override
	public void run(String... args)throws Exception{
		ObjectMapper objectMapper = new ObjectMapper();
		List<IceStockL1> stockList = objectMapper.readValue(resource.getInputStream(), new TypeReference<List<IceStockL1>>() {});
		Flux.fromIterable(stockList)
				.delayElements(Duration.ofSeconds(2))
				.flatMap(this.stockRepo::save)
				.doOnComplete(() -> System.out.println("Complete"))
				.subscribe();
	}

	 */
}
