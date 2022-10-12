package com.mphasis.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mphasis.bookstore.domain.Book;
import com.mphasis.bookstore.repository.BookRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {
@Autowired
@Qualifier("bookRepository")
private BookRepository bookRepository;
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
		System.out.println("This is springboot");
	}

	@Override
	public void run(String... args) throws Exception {
		bookRepository.save(new Book(0,"Atom",965));
		bookRepository.save(new Book(0,"Marcus",969));
		bookRepository.save(new Book(0,"mindPower",968));
		bookRepository.save(new Book(0,"power",967));
		System.out.println(bookRepository.findAll());
		
	}

}
