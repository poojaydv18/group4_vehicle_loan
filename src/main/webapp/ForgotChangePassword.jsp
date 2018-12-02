<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
     <!DOCTYPE html >

<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Forget Password</title>

       

  
    </head>
    <body>
  
  <h1>Change password</h1>  
   <form  action="forgetchangepassword"  method="post">
<table border="2" width="70%" cellpadding="2">  
<tr><th>Email</th><th>New password</th><th>Confirm Password</th></tr>  
   <tr>  
   <td><input type="email" name="email" value="<%= session.getAttribute("email") %>" readonly></td>  
   <td><input type="text" name="password"> </td>  
   <td><input type="text"> </td>
   
   </tr>  
   </table>  
   <br/>  
 <input type="submit" value="submit">
  </a> 
  </form>
        </body>

</html>
