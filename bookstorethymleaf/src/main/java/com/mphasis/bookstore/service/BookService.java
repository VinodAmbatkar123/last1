package com.mphasis.bookstore.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.mphasis.bookstore.domain.Book;
import com.mphasis.bookstore.repository.BookRepository;
@Service("bookService")
@Scope("singleton")
public class BookService implements IBookService {
	@Autowired
	@Qualifier("bookRepository")
	private BookRepository bookRepository;
	
	

	@Override
	public Book save(Book book) {
		
		return bookRepository.save(book);
	}

	@Override
	public Book update(Book book) {
		return bookRepository.save(book);
		
		
	}

	@Override
	public void delete(int id) {
		bookRepository.deleteById(id);
		
	}

	@Override
	public List<Book> getAllBook() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	@Override
	public Book getBookById(int id) {
		// TODO Auto-generated method stub
		return bookRepository.findById(id).get();
	}

	@Override
	public List<Book> getAllBookByName(String name) {
		// TODO Auto-generated method stub
		return bookRepository.findByNameLike(name)	;
				}

	
	

	
	

	@Override
	public List<Book> getAllBookByPrice(int price) {
		// TODO Auto-generated method stub
		return bookRepository.findByPrice(price);
	}

	@Override
	public void patchBook(Map<String, Object> updates, int id) {
		// TODO Auto-generated method stub
		Book dbBook=bookRepository.findById(id).get();
		Integer price=(Integer)updates.get("price");
		if(price !=null) {
			dbBook.setPrice(price);
			bookRepository.save(dbBook);
		}
	}

	


}
