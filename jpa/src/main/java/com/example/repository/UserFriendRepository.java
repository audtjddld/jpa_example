package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.User;
import com.example.entity.UserFriend;
import com.example.entity.UserVO;

/**
 * 친구
 * @author 정명성
 * create date : 2015. 12. 9.
 * 설명 : 
 * com.example.repository.UserFriendRepository.java
 */
public interface UserFriendRepository extends JpaRepository<UserFriend, String> {	
	
	List<UserFriend> findByUser(User user);
}
