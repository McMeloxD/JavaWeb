package com.neu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.RowMapper;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.neu.bean.User;
import com.neu.util.DBUtil;

/**
 * 对应user表的持久层
 */
public class UserDao {
	/**
	 * 根据用户名查找用户一条记录
	 * @param userName 用户名字
	 * @return User 用户Bean
	 * @throws SQLException 
	 */
	public User getUserByName(String userName) throws SQLException {
		//获取数据库连接
		Connection con = DBUtil.getConnection();
		//创建QueryRunner对象
		QueryRunner runner = new QueryRunner();
		//写SQL	语句
		String sql = "select * from user where userName = ?";
		//调用方法
		User user = (User) runner.query(con,sql, new BeanHandler(User.class),
				new Object[] {userName});
		return user;
			}
	
	/**
	 * 所有用户表的信息
	 * @return 用户列表
	 * @throws SQLException 
	 */
	public List<User> getAll() throws SQLException {
		//代码编写处
		//获取数据库连接
				Connection con = DBUtil.getConnection();
				//创建QueryRunner对象
				QueryRunner runner = new QueryRunner();
				//写SQL	语句
				String sql = "select * from user";
				List<User> users = (List<User>) runner.query(con,sql, 
						new BeanListHandler(User.class));
		return users;//请修改代码
	}

}
