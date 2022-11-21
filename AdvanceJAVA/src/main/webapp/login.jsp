<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action="UserController" method="post">
	
		<%String msg=(String)request.getAttribute("msg"); %>
		<%if(msg!=null){ %>
		<h3><%out.print(msg); %></h3>
		<% }%>
		
		<%String msg1=(String)request.getAttribute("msg1"); %>
		<%if(msg1!=null){ %>
		<h3><%out.print(msg1); %></h3>
		<% }%>
		<table>
			<tr><td>Email</td><td><input type="email" name="email"></td></tr>
			<tr><td>Password</td><td><input type="password" name="password"></td></tr>
			<tr><td></td><td><input type="submit" name="action" value="login"></td></tr>
		</table>
	</form>
</body>
</html>