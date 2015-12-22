package com.example.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.user.vo.User;
import com.example.user.vo.UserFriend;
import com.example.user.vo.UserVO;

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
