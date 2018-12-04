<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isErrorPage="true"%>
<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
if(session!=null)
{
	if(session.getAttribute("isLoggedIn")==null)
	{
		
		response.sendRedirect("Index.jsp");
	}
}
%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">


	<title>Error</title>

<script type="text/javascript" src="js/back.js"></script>

	<link href="https://fonts.googleapis.com/css?family=Nunito:400,700" rel="stylesheet">

	<!-- Custom stlylesheet -->
	<link type="text/css" rel="stylesheet" href="css/error_css.css" />

	

</head>

<body>

	<div id="notfound">
		<div class="notfound">
			<div class="notfound-404"></div>
			<h1>404</h1>
			<h2>Oops! Page Not Be Found</h2>
			<p>Sorry but the page you are looking for does not exist, have been removed. name changed or is temporarily unavailable</p>
			<a href="Index.jsp">Back to homepage</a>
		</div>
	</div>

</body>

</html>


