<%@page import="org.eclipse.jdt.internal.compiler.ast.Annotation.AnnotationTargetAllowed"%>
<%@page import="UserModel.*"  %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
  <title>Home</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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
		
		<h1>Welcome, <%=u.getName() %></h1>
	
	
	
<div class="container">
  <h2>Basic Table</h2>
  <p>The .table class adds basic styling (light padding and only horizontal dividers) to a table:</p>            
  <table class="table">
    <thead>
      <tr>
            <th>Id</th>
        	<th>Name</th>
        	<th>Contact</th>
        	<th>Address</th>
        	<th>Email</th>
        	<th>Password</th>
      </tr>
    </thead>
    <tbody>
     		<tr><%=u.getId() %>
    </tbody>
  </table>
</div>

</body>
</html>














