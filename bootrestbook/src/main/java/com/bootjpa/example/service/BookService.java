package com.bootjpa.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootjpa.example.dao.BookRepository;
import com.bootjpa.example.entities.Book;


@Component
public class BookService {

	
//	private static List <Book> list = new ArrayList<>();
//	
//	static {
//		list.add(new Book(32, "43qe","34e3re"));
//		list.add(new Book(232, "241qfrdc43qe","fvc 34e3re"));
//
//		list.add(new Book(4332, "dscxz43qe","cdsx34e3re"));
//
//	}
	@Autowired
	private BookRepository bookRepository;
	
	public List <Book> getAllBooks(){
		 List<Book> list=(List<Book>) this.bookRepository.findAll();
		return list;
	}
	public Book getAllBooksbyId(int id){
		Book book = null;
		book=this.bookRepository.findById(id);
		return book;
	}
	public Book addbook(Book book)  {
		
		
		Book res =bookRepository.save(book);
		return res;
	}
	
	public void delteBook(int bid) {
		bookRepository.deleteById(bid);;
	}
	
}
