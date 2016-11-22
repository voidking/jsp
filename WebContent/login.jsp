<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>简易留言板</title>
</head>
<body bgcolor="#E3E3E3">
<form action="mainServlet" method="post">
<table>
	<caption>用户登录</caption>
	<tr>
		<td>
			用户名：<input type="text" name="username" size="20"/>
		</td>
	</tr>
	<tr>
		<td>
			密&nbsp;&nbsp;码：<input type="password" name="password" size="21"/>
		</td>
	</tr>
	<tr>
		<td>
			<input type="submit" value="登录"/>
			<input type="reset" value="重置"/>
		</td>
	</tr>
</table>
</form>
如果没注册单击<a href="register.jsp">这里</a>注册！
</body>
</html>