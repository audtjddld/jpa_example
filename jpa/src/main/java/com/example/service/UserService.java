package com.example.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.User;
import com.example.entity.UserFriend;
import com.example.entity.UserVO;
import com.example.repository.UserFriendRepository;
import com.example.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserFriendRepository userFriendRepository;
	
	public User findUser(String _id) {
		return userRepository.findBy_id(_id);
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
	@Transactional
	public void save(User user) {
		userRepository.save(user);
		//userRepositoryImpl.persist(user);
	}

	
	/**
	 * 사용자 정보 수정
	 * @author 정명성
	 * create date : 2015. 12. 9.
	 * 설명
	 * @param user
	 */
	@Transactional
	public void userUpdate(UserVO userVo ) {
		// 정보 다시 갱신
		User updateUser = userRepository.findOne(userVo.get_id());
		
		BeanUtils.copyProperties(userVo, updateUser);
		
		userRepository.save(updateUser);
		
	}

	/**
	 * 사용자 삭제
	 * @author 정명성
	 * create date : 2015. 12. 9.
	 * 설명
	 * @param _id
	 */
	public void userDelete(String _id){
		userRepository.delete(_id);
	}	
	
	
	/**
	 * 이메일 찾기
	 * @author 정명성
	 * create date : 2015. 12. 8.
	 * 설명
	 * @param email
	 * @return
	 */
	public int countByEmail(String email){
		
		return userRepository.countByEmail(email);
	}
	
	/**
	 * 사용자 정보 수정 친구 등록
	 * @author 정명성
	 * create date : 2015. 12. 9.
	 * 설명
	 * @param user
	 * @return
	 */
	@Transactional
	public void userFriendUpdate(String _id, String friendNames) {
		
		User user = userRepository.getOne(_id);
		if (user == null) {
			//TODO error 처리
			throw new RuntimeException("회원 아이디가 등록되어 있지 않습니다. _id: " + _id);
		}
		
		UserFriend userFriend = new UserFriend();
		userFriend.setUser(user);
		userFriend.setFriendName(friendNames);
		
		userFriendRepository.save(userFriend);
		
	}
	
	/**
	 * 
	 * @author 정명성
	 * create date : 2015. 12. 9.
	 * 설명
	 * @param _id
	 * @return
	 */
	public List<UserFriend> userFriends(String _id){
		
		User user = new User();
		user.set_id(_id);
		return userFriendRepository.findByUser(user);
	}
	

}
