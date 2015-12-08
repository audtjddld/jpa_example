package com.example.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.entity.User;

@Repository
public class UserRepositoryImpl{

	@Autowired
	EntityManager em ;
	
	
	/**
	 * 인서트
	 * @author 정명성
	 * create date : 2015. 12. 8.
	 * 설명
	 * @param user
	 * @return
	 */
	public User persist(User user){
		em.persist(user);
		return user;
	}
	
}
