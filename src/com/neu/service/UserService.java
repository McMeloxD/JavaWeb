package com.neu.service;

import java.sql.SQLException;
import java.util.List;

import com.neu.bean.User;
import com.neu.dao.UserDao;

/**
 * 
 * 用户管理逻辑层
 *
 */
public class UserService {
	
	private UserDao userDao;
	
	public UserService() {
		userDao=new UserDao();
	}

	/**
	 * 获得单个用户
	 * @param userName 用户名
	 * @return 单个用户
	 * @throws SQLException 
	 */
	public User getUser(String userName) throws SQLException {
		return userDao.getUserByName(userName);
	}
	/**
	 * 获得所有用户
	 * @return 用户列表
	 * @throws SQLException 
	 */
	public List<User> getUsers() throws SQLException {
		return userDao.getAll();
	}
}
