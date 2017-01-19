package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.service.LoginService;

/** 
* @ClassName: ExampleController 
* @Description: 简单页面跳转，测试hot-swapping
* @author xuechen
* @date 2017年1月3日 上午10:30:43 
*  
*/
@Controller
public class ExampleController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping("/example-2")
	public String example1() {
	    return "folder/example";
	}
}
