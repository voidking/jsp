<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.voidking.jsp.model.Message" %>
<%@ page import="com.voidking.jsp.model.User" %>
<%@ page import="com.voidking.jsp.db.DB"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>留言板信息</title>
</head>
<body bgcolor="#E3E3E3">
<% User user = (User)session.getAttribute("user");	
%>
	当前用户为：<%=user.getUsername() %>
	<form action="liuyan.jsp" method="post">

		<table border="1">
			<caption>所有留言信息</caption>
			<tr>
				<th>留言人姓名</th><th>留言时间</th><th>留言标题</th><th>留言内容</th>
			</tr>
		<%
			ArrayList al = (ArrayList)session.getAttribute("al");	
			if(al != null)
			{
				Iterator iter = al.iterator();
				while(iter.hasNext())
				{
					Message message=(Message)iter.next();
		%>						
			<tr>
				<td><%=new DB().getUsername(message.getUserid())%></td>
				<td><%=message.getDate().toString()%></td>
				<td><%=message.getTitle()%></td>
				<td><%=message.getContent()%></td>
			</tr>
		<%
				}
			}
		%>
		</table>
		<input type="submit" value="留言"/>
	</form>
</body>
</html>