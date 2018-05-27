<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>注册</h2>
	<form action="${pageContext.request.contextPath}/RegistServlet" method="post">
		<table width="600" border="1">
			<tr>
				<td>用户名</td>
				<td><input id="username" name="username" type="text"/></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input id="password" name="password" type="password"/></td>
			</tr>
			<tr>
				<td>昵称</td>
				<td><input id="nickname" name="nickname" type="text"/></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input id="email" name="email" type="text"/></td>
			</tr>
			<tr>
				
				<td colspan="2"><input type="submit" value="注册"></td>
			</tr>		
		</table>
		
	</form>
</body>
</html>