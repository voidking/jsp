package com.voidking.jsp.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.voidking.jsp.db.DB;
import com.voidking.jsp.model.Message;
import com.voidking.jsp.model.User;

public class MainServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setContentType("utf8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		DB db = new DB();

		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user");
		if (user == null) {
			user = db.checkUser(username, password);

		}

		session.setAttribute("user", user);

		if (user != null) {

			ArrayList al = db.findMessage();
			session.setAttribute("al", al);
			response.sendRedirect("main.jsp");

		} else {
			response.sendRedirect("login.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
