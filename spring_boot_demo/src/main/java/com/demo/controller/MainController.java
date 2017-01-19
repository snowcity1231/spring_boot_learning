package com.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
* @ClassName: MainController 
* @Description: 
* @author xuechen
* @date 2017年1月3日 上午10:28:00 
*  
*/
@Controller
public class MainController {
	
	/**
	 * 使用Thymeleaf、FreeMarker、Velocity、Groovy、Mstache这些模板引擎时，默认模板配置路径为src/main/resources/templates
	 * 这里使用的是Thymeleaf模板，因此返回"index"即打开src/main/resources/templates目录下index.html页面
	 * 可以在application.properties中修改Thymeleaf的默认配置
	 * @return
	 */
	@RequestMapping("/")
	public String index(ModelMap map, HttpServletRequest request) {
		map.addAttribute("content", "This is Thymeleaf");
	    return "index";
	}
	
	/**
	 * 映射到hello.html
	 * @return
	 */
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
}
