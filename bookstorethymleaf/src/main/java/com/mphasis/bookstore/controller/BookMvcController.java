package com.mphasis.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mphasis.bookstore.service.BookService;

@Controller
@Scope("request")
public class BookMvcController {
@Autowired
@Qualifier("bookService")
	private BookService bookService ;
@GetMapping("/allbook")
public ModelAndView getBook() {
	ModelAndView mv=new ModelAndView(); 
		
	mv.addObject("book",bookService.getAllBook());
	mv.setViewName("index.html");
	return mv;
}
}
