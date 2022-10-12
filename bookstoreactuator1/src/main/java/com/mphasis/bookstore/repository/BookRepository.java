package com.mphasis.bookstore.repository;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mphasis.bookstore.domain.Book;

@Repository("bookRepository")
@Scope("singleton")
public interface BookRepository extends JpaRepository<Book,Integer>{

List<Book>findByPrice(int price);
List<Book>findByNameLike(String name);



}
