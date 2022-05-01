package com.neu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neu.bean.User;
import com.neu.service.UserService;

/**
 * 登录Servlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * 登录验证
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		//获取登录提交的信息
		String username= request.getParameter("userName");
		String password= request.getParameter("password");
		//将获取的登录账户密码与调用UserService的getUser方法的结果进行判断
		UserService userservice = new UserService();
		try {
			User user = userservice.getUser(username);
			if(user != null) {
				if(user.getPassword().equals(password)) {
					response.getWriter().print("恭喜你登录成功，3秒后自动跳转");
					//登录成功，将用户名保存到session中，键值名称user
					request.getSession().setAttribute("user",username);
					//跳转到users页面,url后面不能跟.jsp，users是UserServlet的请求路径
					response.setHeader("refresh", "3;url=users");
				}else {
					response.getWriter().print("抱歉，密码错误，3秒后自动跳转到登录页面");
					//登录失败，自动跳转登录页面
					response.setHeader("refresh", "3;url=login.jsp");
				}
			}else {
				response.getWriter().print("抱歉，没有找到该用户,请注册！!");
				//登录失败，自动跳转登录页面
				response.setHeader("refresh", "3;url=login.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
