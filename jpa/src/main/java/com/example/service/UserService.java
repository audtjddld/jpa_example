package com.example.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.entity.User;
import com.example.entity.UserFriend;
import com.example.entity.UserVO;

public interface UserService {

	User findUser(String _id);

	/**
	 * 전체 검색 <페이징>
	 * 
	 * @author 정명성 create date : 2015. 12. 8. 설명
	 * @param pageable
	 * @return
	 */
	Page<User> findAll(Pageable pageable);

	/**
	 * 정보 저장
	 * 
	 * @author 정명성 create date : 2015. 12. 7. 설명
	 * @param user
	 */
	void save(User user);

	/**
	 * 사용자 정보 수정
	 * @author 정명성
	 * create date : 2015. 12. 9.
	 * 설명
	 * @param user
	 */
	void userUpdate(UserVO userVo);

	/**
	 * 사용자 삭제
	 * @author 정명성
	 * create date : 2015. 12. 9.
	 * 설명
	 * @param _id
	 */
	void userDelete(String _id);

	/**
	 * 이메일 찾기
	 * @author 정명성
	 * create date : 2015. 12. 8.
	 * 설명
	 * @param email
	 * @return
	 */
	int countByEmail(String email);

	/**
	 * 사용자 정보 수정 친구 등록
	 * @author 정명성
	 * create date : 2015. 12. 9.
	 * 설명
	 * @param user
	 * @return
	 */
	void userFriendUpdate(String _id, String friendNames);

	/**
	 * 
	 * @author 정명성
	 * create date : 2015. 12. 9.
	 * 설명
	 * @param _id
	 * @return
	 */
	List<UserFriend> userFriends(String _id);

}