package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bean.User;
import com.demo.dao.UserDao;

/** 
* @ClassName: LoginServiceImpl 
* @Description: TODO
* @author xuechen
* @date 2017年1月3日 上午11:06:14 
*  
*/
@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private UserDao userDao;

	/* (non-Javadoc)
	 * @see com.demo.service.LoginService#login()
	 */
	@Override
	public boolean login(String userName, String passWord) {
		User user = userDao.selectByUserName(userName);
		if(user != null) {
			return true;
		}else {
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see com.demo.service.LoginService#selectList()
	 */
	@Override
	public List<User> selectList() {
		return userDao.selectAll();
	}

}
