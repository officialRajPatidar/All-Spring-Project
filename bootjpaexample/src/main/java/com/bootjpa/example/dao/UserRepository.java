package com.bootjpa.example.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bootjpa.example.entity.User;

public interface UserRepository  extends CrudRepository<User, Integer>{

	public List<User> findByName(String name);
	
}
