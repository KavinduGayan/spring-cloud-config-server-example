package com.bookstore.bookstoreprice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BookstorePriceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstorePriceApplication.class, args);
	}

}
@RestController
class BookController{
	@GetMapping("/books/prices/new")
	public ResponseEntity<List<Book>> getPrices() {
		List<Book> books=new ArrayList<>(Arrays.asList(new Book(1,10.0),
				new Book(1,10.0),
				new Book(2,20.0),
				new Book(3,30.0)));
		return new ResponseEntity<>(books, HttpStatus.ACCEPTED);
	}
}

class Book{
	private int bookId;
	private double price;

	public Book(int bookId, double price) {
		this.bookId = bookId;
		this.price = price;
	}

	public Book() {
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
