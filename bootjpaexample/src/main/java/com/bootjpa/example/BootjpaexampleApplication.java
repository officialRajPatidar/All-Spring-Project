package com.bootjpa.example;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.bootjpa.example.dao.UserRepository;
import com.bootjpa.example.entity.User;

@SpringBootApplication
public class BootjpaexampleApplication {

	

	public static void main(String[] args) {
	ApplicationContext context =	SpringApplication.run(BootjpaexampleApplication.class, args);
	UserRepository userRepositroy = context.getBean(UserRepository.class);
//	User user = new User();
//	user.setName("raj");
//	user.setCity("indore");
//	user.setStatus("i sprin g boot developer");
	
	//save the multi user
//	User u1 = new User();
//	u1.setName("ram");
//	u1.setCity("sehore");
//	u1.setStatus("not good");
//	
//
//	User u2 = new User();
//	u2.setName("ramraj");
//	u2.setCity("bhoapalsehore");
//	u2.setStatus("very poor and not good");
//	
//	
//	List <User> users = List.of(u1,u2);
//	Iterable<User> result = userRepositroy.saveAll(users);
//	result.forEach(user->{
//		System.out.println(user);
//	});
	
	
	//update
	
//	Optional<User> optinal = userRepositroy.findById(3);
//	User user = optinal.get();
//	System.out.println(user);
//	user.setName("ghanshayam");
//	
//	User  res =userRepositroy.save(user);
//	System.out.println(res);
	
	
	
	//get whole dtata
	Iterable<User> itr = userRepositroy.findAll();
	
	itr.forEach(user->{System.out.println(user);
	});
	
	//delete 
	
//	userRepositroy.deleteById(3);
//	System.out.println("dlete");
	List<User> findByName = userRepositroy.findByName("raj");
	findByName.forEach(user->System.out.println(user));

}}
