package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Address;
import com.example.entity.User;
import com.example.entity.UserFriend;
import com.example.entity.UserVO;
import com.example.service.UserService;

@RestController
public class UserRestController {
	
	@Autowired
	UserService userService;
	
	/**
	 * 사용자 상세정보 가져오기
	 * @author 정명성
	 * create date : 2015. 12. 7.
	 * 설명
	 * @param _id
	 * @return
	 */
	@RequestMapping(value="/rest/users/{_id}" , method = RequestMethod.GET)
	User user(@PathVariable("_id") String _id ) {
		System.out.println("사용자 정보 " + _id);
		return userService.findUser(_id);
	}
	
	/**
	 * 사용자 데이터 가져오기
	 * @author 정명성
	 * create date : 2015. 12. 7.
	 * 설명
	 * @param user
	 * @param pageable
	 * @return
	 */
	@RequestMapping(value="/rest/users", method = RequestMethod.GET)
	Page<User> userList(@ModelAttribute User user, Pageable pageable) throws Exception{
		
		try {
			return userService.findAll(pageable);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	/**
	 * 사용자 정보 입력
	 * @author 정명성
	 * create date : 2015. 12. 7.
	 * 설명
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/rest/users",method = RequestMethod.POST)
	User user( @RequestBody @Valid User user,
				BindingResult biResult ) throws Exception{
		
		System.out.println(user.toString());
		//System.out.println(addr.toString());
		
		if(biResult.hasErrors()){
			throw new Exception("입력값이 올바르지 않습니다.");
		}
		// 주소 저장
		//user.setAddress(addr);
		// 정보 저장
		userService.save(user);
		
		return user;
	}
	
	/**
	 * 사용자 정보 수정
	 * @author 정명성
	 * create date : 2015. 12. 9.
	 * 설명
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/rest/users", method = RequestMethod.PUT)
	public void userUpdate(@RequestBody UserVO user){
		System.out.println(user.toString());
		// 수정
		 userService.userUpdate(user);
	}	
	
	/**
	 * 이메일 주소 체크
	 * @author 정명성
	 * create date : 2015. 12. 8.
	 * 설명
	 * @param email
	 * @return
	 */
	@RequestMapping(value="/rest/email/exist", method = RequestMethod.GET)
	int findEmailAddress (String email, HttpServletRequest request){
		
		return userService.countByEmail(email);
	}

	
	/**
	 * 사용자 친구 정보 등록
	 * @author 정명성
	 * create date : 2015. 12. 9.
	 * 설명
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/rest/users/{_id}/friends", method = RequestMethod.PUT)
	public void userFriendUpdate(@PathVariable String _id,
								@RequestBody String friendNames){
		
		userService.userFriendUpdate(_id, friendNames);
	}
	
	/**
	 * 
	 * @author 정명성
	 * create date : 2015. 12. 9.
	 * 설명
	 * @param _id
	 * @return
	 */
	@RequestMapping(value="/rest/users/{_id}/friends", method = RequestMethod.GET)
	public List<UserFriend> userFriends(@PathVariable String _id) {
		
		return userService.userFriends(_id);
		
	}
	
	
	/**
	 * 사용자 삭제
	 * @author 정명성
	 * create date : 2015. 12. 9.
	 * 설명
	 * @param _id
	 */
	@RequestMapping(value="/rest/users/{_id}", method = RequestMethod.DELETE)
	public void userDelete(@PathVariable String _id){
		userService.userDelete(_id);
		
	}
}
