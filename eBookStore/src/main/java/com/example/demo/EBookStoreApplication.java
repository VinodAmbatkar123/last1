package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.Book;
import com.example.demo.repository.BookRepository;

@SpringBootApplication
public class EBookStoreApplication implements CommandLineRunner{
	
	@Autowired
	@Qualifier("bookRepository")
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(EBookStoreApplication.class, args);
		System.out.println("******** This is Spring Boot Application ***********");
	}

	@Override
	public void run(String... args) throws Exception {
	
		bookRepository.save(new Book(101, "java", "vinod", 1001));
		bookRepository.save(new Book(102, "hindi", "tina", 5201));
		bookRepository.save(new Book(103, "marathi", "paro",8502));
		bookRepository.save(new Book(101, "python", "namo", 3001));
		System.out.println(bookRepository.findAll());
		
	}

}
