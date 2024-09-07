package com.bootjpa.example.dao;
import org.springframework.data.repository.CrudRepository;

import com.bootjpa.example.entities.Book;
public interface BookRepository extends CrudRepository<Book,Integer>{
	
	public Book findById(int id);
}
