package com.neu.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neu.bean.User;
import com.neu.service.UserService;

/**
 * 用户管理Servlet
 */
@WebServlet("/users")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 1、登录session验证
	 * 2、显示所有用户信息
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		//从session对象中取出键值user的值判断是否为空
		if(request.getSession().getAttribute("user")!=null) {
			//若不为空，创建UserService对象，调用其中获得所有数据的方法发
			UserService userservice = new UserService();
			try {
				List<User> users = userservice.getUsers();
				//将返回结果放入到request对象中，键值名为userList
				request.setAttribute("userList", users);
				//转发到users.jsp
				request.getRequestDispatcher("/users.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			response.getWriter().print("您还未登录，请重新登录~");
			//若为空，跳转到login.jsp
			response.setHeader("refresh", "3;url=login.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
