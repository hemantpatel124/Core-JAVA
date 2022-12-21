<%@page import="sModel.Member"%>
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
		Member m=null;
				if(session.getAttribute("data")!=null){
			m=(Member)session.getAttribute("data");
				}
				else{
			response.sendRedirect("member_login.jsp");
				}
		%>
		<h3>
			Welcome
		</h3>
</body>
</html>