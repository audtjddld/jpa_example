package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
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
	@RequestMapping(value="/rest/user/{_id}" , method = RequestMethod.GET)
	User user(@PathVariable("_id") String _id ) {
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
	@RequestMapping(value="/rest/user/list", method = RequestMethod.GET)
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
	@RequestMapping(value="/rest/user/save")
	User user(@ModelAttribute User user){
		
		userService.save(user);
		
		return user;
	}
	
	/**
	 * 이메일 주소 체크
	 * @author 정명성
	 * create date : 2015. 12. 8.
	 * 설명
	 * @param email
	 * @return
	 */
	@RequestMapping(value="/rest/memail/exist", method = RequestMethod.GET)
	int findEmailAddress (@Param(value="email") String email){
		
		String data = userService.findByEmail(email);
		int result = 0;
		if(data != null){
			result = 1;
		}
		
		return result;
	}
	
}
