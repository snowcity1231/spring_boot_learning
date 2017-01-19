package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/** 
* @ClassName: Application 
* @Description: 用于启动程序的主类
* @author xuechen
* @date 2017年1月3日 上午9:22:56 
*  
*/
@Configuration
@ComponentScan
@EnableAutoConfiguration
@MapperScan("com.demo.dao")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
