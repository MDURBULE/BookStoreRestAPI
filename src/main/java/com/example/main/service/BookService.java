package com.example.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.main.dao.BookRepository;
import com.example.main.entities.Book;


@Component
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
//	private static List<Book> list = new ArrayList<>();
//	
//	static {
//		list.add(new Book(23,"java","manish"));
//		list.add(new Book(34,"c++","nanaji"));
//		list.add(new Book(45,"c","mayur"));
//		list.add(new Book(36,"python","dj"));
//		list.add(new Book(234,"kotlin","pandit"));
//	}
	
	public List<Book> getAllBooks(){
		return (List<Book>) this.bookRepository.findAll();
	}
	
	public Book getBooById(int id) {
		Book book = null;
//		book = list.stream().filter(e->e.getId()==id).findFirst().get();
		book = this.bookRepository.findById(id);
		return book;
	}
	
	public Book addBook(Book book) {
//		list.add(book);
		Book bk =this.bookRepository.save(book);
		return bk;
		}

	public void deleteBook(int id) {
//		list = list.stream().filter(e->e.getId()!=id).collect(Collectors.toList());
		this.bookRepository.deleteById(id);
		
	}

	public void updateBook(Book book ,int id) {
//		list=list.stream().map(b->{
//			if(b.getId()==id) {
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
		book.setId(id);
		this.bookRepository.save(book);
	}
		
}
