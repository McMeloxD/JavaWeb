package com.neu.bean;

/**
 * 对应用户表user的JavaBean
 *User JavaBean
 *
 */
public class User {
	//代码编写处
	private String id; //用户编号
	private String userName; //用户名
	private String password; //密码
	//默认构造方法
	public User() {}
	//包含username和password两个参数的构造方法	
	public User(String userName,String password) {
		this.userName = userName;
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
