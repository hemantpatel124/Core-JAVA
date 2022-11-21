<%@page import="model.User"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
		<%
			User u=null;
			
			if(session.getAttribute("data")!=null){
				u=(User)session.getAttribute("data");
			}
			else{
				response.sendRedirect("login.jsp");
			}
		%>
		
		
		<h1>WellCom , <%=u.getName()%></h1>
		<h2>Your details is here:</h2>
		<h3>ID : <%=u.getId() %></h3>
		<h3>Name : <%=u.getName() %></h3>
		<h3>Address : <%=u.getAddress() %></h3>
		<h3>Contact : <%=u.getContact() %></h3>
		<h3>Email : <%=u.getEmail() %></h3>
		<h3>Password : <%=u.getPassword() %></h3>
		
</body>
</html>