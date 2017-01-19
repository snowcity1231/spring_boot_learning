package com.demo.service;

import java.util.List;

import com.demo.bean.User;

/** 
* @ClassName: LoginService 
* @Description: TODO
* @author xuechen
* @date 2017年1月3日 上午11:05:47 
*  
*/
public interface LoginService {

	boolean login(String userName, String passWord);
	
	List<User> selectList();
}
