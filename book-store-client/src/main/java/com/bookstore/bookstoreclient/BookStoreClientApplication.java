package com.bookstore.bookstoreclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
@RestController
@RefreshScope
public class BookStoreClientApplication {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(BookStoreClientApplication.class, args);
    }

    @Autowired
    @Lazy
    private RestTemplate restTemplate;
    @Value("${book.provider.url}")
    private String url;

    @GetMapping("/prices")
    public ResponseEntity<List> getPrices() {
        return new ResponseEntity<>(restTemplate.getForObject(url, List.class), HttpStatus.ACCEPTED);
    }
}


