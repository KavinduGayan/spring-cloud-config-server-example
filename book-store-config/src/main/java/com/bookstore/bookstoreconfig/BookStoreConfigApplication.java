package com.bookstore.bookstoreconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class BookStoreConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreConfigApplication.class, args);
	}

}
