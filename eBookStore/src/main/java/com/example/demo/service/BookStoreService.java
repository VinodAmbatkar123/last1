package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Book;
import com.example.demo.repository.BookRepository;

@Service("bookstoreService")
@Scope("singleton")
public class BookStoreService implements IBookStoreService {

	@Autowired
	@Qualifier("bookRepository")
	private BookRepository bookRepository;

	@Override
	public Book update(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public void delete(int id) {
		bookRepository.deleteById(id);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book save(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Book getAllBooksById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getAllBooksByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getAllBooksByPrice(int price) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
