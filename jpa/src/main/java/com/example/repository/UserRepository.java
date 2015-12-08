package com.example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
//JpaRepository<User, String> {
	
	
	User findOne(String _id);
	
	User save(User user);
	
	//Page<User> findAll(Pageable pabeable);
	Page<User> findAll(Pageable pageable);
	
	String findByEmail(String email);
	
}
