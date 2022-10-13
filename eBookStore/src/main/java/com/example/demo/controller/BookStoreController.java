 package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Book;
import com.example.demo.service.IBookStoreService;

@RestController
@Scope("request")
@RequestMapping("/store")
public class BookStoreController {

	@Autowired
	@Qualifier("bookstoreService")
	private IBookStoreService bookstoreService;
	
	@RequestMapping("/")
	public String Home() {
		return "Welcome To BookStore world";
	}
	
	@GetMapping(value = "/book", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Book> getAllBooks(){
		return bookstoreService.getAllBooks();
		
	}
	@PostMapping(value="/insertbook", produces = {MediaType.APPLICATION_JSON_VALUE}, 

			consumes = {MediaType.APPLICATION_JSON_VALUE}) 

			@ResponseStatus(code=HttpStatus.CREATED) 

			public Book insertBook(@RequestBody Book book) { 

			return bookstoreService.save(book); 

			} 

			 

			@PutMapping(value="/updatebook", produces = {MediaType.APPLICATION_JSON_VALUE}) 

			@ResponseStatus(code=HttpStatus.OK) 

			public Book updateAnyProduct(@RequestBody Book book){ 

			return bookstoreService.update(book); 

			} 
			@DeleteMapping(value="/deletebook/{id}") 

			@ResponseStatus(code=HttpStatus.NO_CONTENT) 

			public  void deleteProductbyId(@PathVariable int id){ 

			 bookstoreService.delete(id); 

			} 
			@GetMapping(value="/bookbyid/{id}", produces = {MediaType.APPLICATION_JSON_VALUE}) 

			public Book getProductById(@PathVariable int id){ 

			return bookstoreService.getAllBooksById(id); 

			} 

			@GetMapping(value="/bookbyname/{name}", produces = {MediaType.APPLICATION_JSON_VALUE}) 

			public List<Book> getProductByname(@PathVariable String name){ 

			return bookstoreService.getAllBooksByName(name); 

			} 

			@GetMapping(value="/productbyprice/{price}", produces = {MediaType.APPLICATION_JSON_VALUE}) 

			public List<Book> getBooktByprice(@PathVariable int price){ 

			return bookstoreService.getAllBooksByPrice(price); 

			} 
			
}
