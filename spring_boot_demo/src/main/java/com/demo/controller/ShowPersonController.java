package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.bean.Person;

/** 
* @ClassName: ShowPersonController 
* @Description: 控制层，用于响应请求
* @author xuechen
* @date 2017年1月3日 上午9:21:04 
*  
*/
@Controller
public class ShowPersonController {

	@RequestMapping("/showPerson")
	public @ResponseBody Person showPerson() {
		return new Person("tom", "tom@qq.com");
	}
}
