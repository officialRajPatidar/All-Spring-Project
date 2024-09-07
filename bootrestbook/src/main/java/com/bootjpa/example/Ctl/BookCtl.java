package com.bootjpa.example.Ctl;

import java.util.List;

import org.hibernate.dialect.MySQL8Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootjpa.example.entities.Book;
import com.bootjpa.example.service.BookService;

@RestController
public class BookCtl {
	
	
	
	@Autowired
	private BookService bookservice;
	
	@GetMapping("/books")

	public List< Book> getbooks() {
		
		
		return this.bookservice.getAllBooks();
	}

	@PostMapping("/books")
	public Book addb(@RequestBody Book book) {
	Book b = 	this.bookservice.addbook(book);
	return b;
	}
	
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId) {
		this.bookservice.delteBook(bookId);
	}
}
