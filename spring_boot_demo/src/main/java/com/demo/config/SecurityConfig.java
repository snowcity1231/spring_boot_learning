package com.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.demo.service.LoginService;
import com.demo.service.UserDetailService;

/** 
* @ClassName: SecurityConfig 
* @Description: TODO
* @author xuechen
* @date 2017年1月5日 下午2:06:23 
*  
*/
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	LoginService loginService;
	@Autowired
	UserDetailService userDetailService;

	/**
	 * 创建用户
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		//直接使用常量字符串，将用户信息存放在内存中
//		List<User> list = loginService.selectList();
//		InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> userConfig = auth.inMemoryAuthentication();
//		for(int i=0; i<list.size(); i++) {
//			User user = list.get(i);
//			userConfig.withUser(user.getUsername()).password(user.getPassword()).roles("USER");
//			
//		}
		//使用userDetailsService从自定义的数据源获取用户数据，并采用MD5加密
		Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();  
		auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/", "/log").permitAll()		//指定不需要认证就可以访问的IP
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")		//定义当用户需要登录时的跳转页面
				.permitAll()
				.and()
			.logout()
				.permitAll();
	}
}
