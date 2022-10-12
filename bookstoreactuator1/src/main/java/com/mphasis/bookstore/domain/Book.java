package com.mphasis.bookstore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Books_Details")
public class Book {
	@Id
	@Column(name="Book_Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="Book_Name")
	private String name;
	
	@Column(name="Book_price")
	private int price;
	
	
	
	public Book() {}
	public Book(Integer id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String nmae) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice( int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	

}
