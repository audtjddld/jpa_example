package com.example.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.repository.UserRepositoryImpl;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserRepositoryImpl userRepositoryImpl;
	
	@Transactional
	public User findUser(String _id) {
		return (User) userRepository.findOne(_id);
	}

	/**
	 * 전체 검색 <페이징>
	 * 
	 * @author 정명성 create date : 2015. 12. 8. 설명
	 * @param pageable
	 * @return
	 */
	public Page<User> findAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	/**
	 * 정보 저장
	 * 
	 * @author 정명성 create date : 2015. 12. 7. 설명
	 * @param user
	 */
	public void save(User user) {
		userRepository.save(user);
		//userRepositoryImpl.persist(user);
	}

	/**
	 * 저장
	 * 
	 * @author 정명성 create date : 2015. 12. 7. 설명
	 * @param next
	 */
	public void put(User next) {
		User prev = (User) userRepository.findOne(next.get_id());

		prev = next;

		userRepository.save(next);

	}
	
	/**
	 * 이메일 찾기
	 * @author 정명성
	 * create date : 2015. 12. 8.
	 * 설명
	 * @param email
	 * @return
	 */
	public String findByEmail(String email){
		
		String data = userRepository.findByEmail(email);
		
		return data;
	}
}
