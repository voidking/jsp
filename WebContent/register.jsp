<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body bgcolor="#E3E3E3">
	<form action="registerServlet" method="post">
		<table>
			<caption>用户注册</caption>
			<tr>
				<td>登录名</td>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password"/></td>
			</tr>
		</table>
		<input type="submit" value="注册" />
		<input type="reset" value="重置"/>
	</form>

</body>
</html>