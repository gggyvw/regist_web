package com.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.UserService;
import com.service.impl.UserServiceImpl;
import com.somain.User;

/**
 * Servlet implementation class ActiveServlet
 */
public class ActiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String code = request.getParameter("code");
			UserService userService = new UserServiceImpl();
			User user = userService.findByCode(code);
			if(user!=null){
				user.setState(1);
				user.setCode(null);
				userService.update(user);
				request.setAttribute("msg", "您已经激活成功！请去登录！");
			}else{
				request.setAttribute("msg", "您的激活码有误！请重新激活！");
			}
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
