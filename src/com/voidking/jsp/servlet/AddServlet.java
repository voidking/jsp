package com.voidking.jsp.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.voidking.jsp.db.DB;
import com.voidking.jsp.model.Message;
import com.voidking.jsp.model.User;

public class AddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		User user = (User) request.getSession().getAttribute("user");

		Message message = new Message();
		message.setUserid(user.getId());
		message.setDate(new Date(System.currentTimeMillis()));
		message.setTitle(title);
		message.setContent(content);

		if (new DB().addMessage(message)) {
			response.sendRedirect("success.jsp");

		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
