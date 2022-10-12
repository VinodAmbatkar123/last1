package com.mphasis.bookstore.service;

import java.util.List;
import java.util.Map;

import com.mphasis.bookstore.domain.Book;

public interface IBookService {
	Book save(Book book);
	Book update(Book book);
	void delete(int id);
	List<Book> getAllBook();
	Book getBookById(int id);
	List<Book> getAllBookByName(String name);
	List<Book> getAllBookByPrice(int price);
	
	void patchBook(Map<String, Object> updates, int id);

}
