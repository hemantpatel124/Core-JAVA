<%@page import="DAO.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%
			int id=Integer.parseInt(request.getParameter("pid"));
			int cusid=Integer.parseInt(request.getParameter("cusid"));
			ProductDAO.removeWishlist(id, cusid); 
			response.sendRedirect("customer_wishlist.jsp");	
		%>
		
</body>
</html>