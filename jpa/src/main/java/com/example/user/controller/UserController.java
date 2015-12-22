package com.example.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	/**
	 * 사용자 페이지 이동 ( 새로고침 시 사용 됨 )
	 */
    @RequestMapping(value ={ "/user/**"}, method = RequestMethod.GET)
    public String getUserIndex() {
    	System.out.println("나 탄당");
        return  "user/index";
    }
  
    
}
