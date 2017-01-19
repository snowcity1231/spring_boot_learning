package com.demo.bean;

/** 
* @ClassName: Person 
* @Description: 用户实体类
* @author xuechen
* @date 2017年1月3日 上午9:19:28 
*  
*/
public class Person {
	private String name;
	private String email;
	
	/**
	 * @param name
	 * @param email
	 */
	public Person(String name, String email) {
		this.name = name;
		this.email = email;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
