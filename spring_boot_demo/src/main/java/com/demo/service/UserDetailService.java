package com.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.bean.User;
import com.demo.dao.UserDao;

/** 
* @ClassName: UserDetailService 
* @Description: 这里为了按照自己的数据库获取用户信息，实现Spring Security中的接口
* @author xuechen
* @date 2017年1月5日 下午2:54:46 
*  
*/
@Service
public class UserDetailService implements UserDetailsService {
	
	@Autowired
	UserDao userDao;

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userDao.selectByUserName(userName);
		
		if(user == null){
            throw new BadCredentialsException("Username not found.");
        }
		
		//可以自己声明类实现UserDetails接口，这里用SpringSecurity默认实现
		return new org.springframework.security.core.userdetails.User(userName, user.getPassword(), new ArrayList<>());
	}

}
