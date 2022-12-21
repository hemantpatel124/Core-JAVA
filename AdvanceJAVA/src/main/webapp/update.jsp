<%@page import="DAO.UserDao"%>
<%@page import="Model.User"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<%User u=(User)request.getAttribute("user"); %>
<body>
	<form action="UserController" method="post">
		<table>
			<tr><td><input type="hidden" name="id" value="<%=u.getId()%>"></td></tr>
			<tr><td>Name :</td><td><input type="text" name="name" value="<%=u.getName()%>"></td></tr>
			<tr><td>Contact :</td><td><input type="text" name="contact" value="<%=u.getContact()%>"></td></tr>
			<tr><td>Address :</td><td><input type="text" name="address" value="<%=u.getAddress()%>"></td></tr>
			<tr><td>Email :</td><td><input type="email" name="email" value="<%=u.getEmail()%>"></td></tr>
			<tr><td>Password :</td><td><input type="text" name="password" value="<%=u.getPassword()%>"></td></tr>
			<tr><td></td><td><input type="submit" name="action" value="update"></td></tr>
		</table>
	</form>
</body>
</html>