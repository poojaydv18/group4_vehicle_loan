<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page isErrorPage="true" %>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">


	<title>404 HTML Template by Colorlib</title>

<script type="text/javascript"  src="back.js"></script>

	<link href="https://fonts.googleapis.com/css?family=Nunito:400,700" rel="stylesheet">

	<!-- Custom stlylesheet -->
	<link type="text/css" rel="stylesheet" href="css/error_css.css" />

	
      <style type="text/css">
      th{
         color:#801525;
         padding: 10px;
         background-color: #44C5FC;
      }
      td{
         padding: 10px;
         color:black;
      }
</style>
	

</head>

<body>

	<div id="notfound">
		<div class="notfound">
			<div class="notfound-404"></div>
			<!-- <h2>Oops! Page Not Be Found</h2>
			<p>Sorry but the page you are looking for does not exist, have been removed. name changed or is temporarily unavailable</p>
			 -->
			
  <table width = "100%" border = "1" cellpadding="4">
         <tr valign = "top">
            <th width = "40%"><b>Error:</b></th>
            <td>${pageContext.exception}</td>
         </tr>
            
         <tr valign = "top">
            <th><b>URI:</b></th>
            <td>${pageContext.errorData.requestURI}</td>
         </tr>
            
         <tr valign = "top">
            <th><b>Status code:</b></th>
            <td>${pageContext.errorData.statusCode}</td>
         </tr>
            
         <tr valign = "top">
            <th><b>Stack trace:</b></th>
            <td>
               <c:forEach var = "trace" 
                  items = "${pageContext.exception.stackTrace}">
                  <p>${trace}</p>
               </c:forEach>
            </td>
         </tr>
      </table>
<br>
			
			<a href="index.jsp">Back to homepage</a>
		</div>
	</div>

</body>

</html>

