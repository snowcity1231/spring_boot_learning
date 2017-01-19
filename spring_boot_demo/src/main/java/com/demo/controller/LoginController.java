package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.LoginService;

/** 
* @ClassName: LoginController 
* @Description: 登陆controller
* @author xuechen
* @date 2017年1月3日 上午10:50:59 
*  
*/
@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping("/login")
	public String toLogin() {
		return "login";
	}

//	@RequestMapping(value = "login")
//	public String login(String userName, String passWord) {
//		if(loginService.login(userName, passWord)) {
//			return "folder/main";
//		}else {
//			return "failed";
//		}
//	}
}
