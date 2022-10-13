package com.example.demo.service;

import java.util.List;



import com.example.demo.domain.Book;

public interface IBookStoreService {
	
	Book save(Book book);
	Book update(Book book);
	void delete(int id);
	List<Book> getAllBooks();
	Book getAllBooksById(int id); 

	List<Book> getAllBooksByName(String name); 

	List<Book> getAllBooksByPrice(int price); 

	 

}
