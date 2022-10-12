package com.mphasis.bookstore.controller;

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

import com.mphasis.bookstore.domain.Book;
import com.mphasis.bookstore.service.IBookService;

@RestController
@Scope("request")
//@Controller
@RequestMapping("/Book")
public class BookController {
	@Autowired
	@Qualifier("bookService")
	private IBookService bookService;
	
	@RequestMapping("/")
	 public String dummyMethod() {
		 return "welcome to Springbboot";
	 }
	
	
	
	//@RequestMapping("/allbook")
	//@ResponseBody
	@GetMapping(value="/book",produces={MediaType.APPLICATION_JSON_VALUE})
	public List<Book> getAllBook()
	{
		return bookService.getAllBook();
	}
	
	@PostMapping(value="/insertbook" , produces = {MediaType.APPLICATION_JSON_VALUE},
	consumes = {MediaType.APPLICATION_JSON_VALUE})
@ResponseStatus(code=HttpStatus.CREATED)
	public Book insertBook(@RequestBody Book book) {
	return bookService.save(book);
	
}
	@PutMapping(value="/updatebook",produces={MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code=HttpStatus.OK)
	public Book updateAnyBook(@RequestBody Book book)
	{
		return bookService.update(book);
	}
	@DeleteMapping(value="/deleteebook/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public  void deleteAnyBookbyId(@PathVariable int id)
	{
		 bookService.delete(id);
	}
	@GetMapping(value="/bookbyid/{id}",produces={MediaType.APPLICATION_JSON_VALUE})
	public Book getBookById(@PathVariable int id)
	
	{
		return bookService.getBookById(id);
	}
	@GetMapping(value="/bookbyname/{name}",produces={MediaType.APPLICATION_JSON_VALUE})
	public List<Book> getBookByname(@PathVariable String name)
	
	{
		return bookService.getAllBookByName(name);
	}
	@GetMapping(value="/bookbyyear/{price}",produces={MediaType.APPLICATION_JSON_VALUE})
	public List<Book> getBookByyear(@PathVariable int price)
	
	{
		return bookService.getAllBookByPrice(price);
	}
	@PatchMapping(value="/patchbook/{id}",consumes ={MediaType.APPLICATION_JSON_VALUE})
	public void patchBook(@RequestBody Map<String,Object>updates,@PathVariable int id)
	
	{
		 bookService.patchBook(updates,id);
	}
}

