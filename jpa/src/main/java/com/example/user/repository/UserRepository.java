package com.example.user.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	User findBy_id(String _id);
	
	//Page<User> findAll(Pageable pabeable);
	Page<User> findAll(Pageable pageable);
	
	Integer countByEmail(String email);
	
}
