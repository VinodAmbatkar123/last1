package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BookDetails")
public class Book {

	@Id
	@Column(name="Book_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="Book_name")
	private String name;
	@Column(name="Book_publisher")
	private String publisher;
	@Column(name="Book_price")
	private int price;
	
	public Book() {}
	public Book(Integer id, String name, String publisher, int price) {
		super();
		this.id = id;
		this.name = name;
		this.publisher = publisher;
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", publisher=" + publisher + ", price=" + price + "]";
	}
	
	
}
