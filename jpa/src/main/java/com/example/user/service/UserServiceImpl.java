package com.example.user.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.User;
import com.example.user.repository.UserFriendRepository;
import com.example.user.repository.UserRepository;
import com.example.user.vo.UserFriend;
import com.example.user.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserFriendRepository userFriendRepository;
	
	/* (non-Javadoc)
	 * @see com.example.service.UserService#findUser(java.lang.String)
	 */
	@Override
	public User findUser(String _id) {
		return userRepository.findBy_id(_id);
	}

	/* (non-Javadoc)
	 * @see com.example.service.UserService#findAll(org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<User> findAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	/* (non-Javadoc)
	 * @see com.example.service.UserService#save(com.example.entity.User)
	 */
	@Override
	@Transactional
	public void save(User user) {
		userRepository.save(user);
		//userRepositoryImpl.persist(user);
	}

	
	/* (non-Javadoc)
	 * @see com.example.service.UserService#userUpdate(com.example.entity.UserVO)
	 */
	@Override
	@Transactional
	public void userUpdate(UserVO userVo ) {
		// 정보 다시 갱신
		User updateUser = userRepository.findOne(userVo.get_id());
		
		BeanUtils.copyProperties(userVo, updateUser);
		
		userRepository.save(updateUser);
		
	}

	/* (non-Javadoc)
	 * @see com.example.service.UserService#userDelete(java.lang.String)
	 */
	@Override
	public void userDelete(String _id){
		userRepository.delete(_id);
	}	
	
	
	/* (non-Javadoc)
	 * @see com.example.service.UserService#countByEmail(java.lang.String)
	 */
	@Override
	public int countByEmail(String email){
		
		return userRepository.countByEmail(email);
	}
	
	/* (non-Javadoc)
	 * @see com.example.service.UserService#userFriendUpdate(java.lang.String, java.lang.String)
	 */
	@Override
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
	
	/* (non-Javadoc)
	 * @see com.example.service.UserService#userFriends(java.lang.String)
	 */
	@Override
	public List<UserFriend> userFriends(String _id){
		
		User user = new User();
		user.set_id(_id);
		return userFriendRepository.findByUser(user);
	}
	

}
