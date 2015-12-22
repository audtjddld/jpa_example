/**
 * 
 */
package com.example.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 정명성
 * create date : 2015. 12. 22.
 * com.example.main.controller.MainController.java
 */
@Controller
public class MainController {

	/**
	 * 메인 디폴트 페이지
	 */
	@RequestMapping(value="/main/**")
	public String mainDefaultPage(){
		
		return "main/index";
	}
	
	/**
	 * 기본 페이지
	 * @author 정명성
	 * create date : 2015. 12. 22.
	 * 설명
	 * @return
	 */
	@RequestMapping(value="/")
	public String defaultPage(){
		
		return "index";
	}
	
}
