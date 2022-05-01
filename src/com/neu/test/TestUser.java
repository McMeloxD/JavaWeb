package com.neu.test;

import java.sql.SQLException;
import java.util.List;

import com.neu.bean.User;
import com.neu.service.UserService;

public class TestUser {

	public static void main(String[] args) throws SQLException {
		UserService userservice =new UserService();
		User user =userservice.getUser("mayuan");
		System.out.println(user);
		List<User> user1 =userservice.getUsers();
		System.out.println(user1);
	}

}
