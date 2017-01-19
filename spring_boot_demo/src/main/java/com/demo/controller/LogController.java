package com.demo.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
* @ClassName: LogController 
* @Description: 记录日志
* @author xuechen
* @date 2017年1月3日 上午10:36:39 
*  
*/
@Controller
public class LogController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/log")
	public @ResponseBody String log() {
		
		log.debug("debug level log");
		log.info("info level log");
		log.error("error level log");
		
		log.debug("another info log with {}, {} and {}", 1, "2", new Date());
		
		return "Proudly handcrafted by " +
		        "<a href='http://netgloo.com/en'>ai</a> :)";
	}

}
