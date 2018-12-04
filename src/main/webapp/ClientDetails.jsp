<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
	<%@ page errorPage="ErrorPage.jsp" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Client Details</title>
</head>
<body>
	<h1>Client Details</h1>
	<table border="2" width="70%" cellpadding="2" align="left">
		<c:forEach var="emp" items="${list}">
			<tr>
				<th>User Id</th>
				<td>${emp.ud.userId}</td>
			</tr>
			<tr>
				<th>Name</th>
				<td>${emp.ud.name}</td>
			</tr>
			<tr>
				<th>Gender</th>
				<td>${emp.ud.gender}</td>
			</tr>
			<tr>
				<th>Age</th>
				<td>${emp.ud.age}</td>
			</tr>
			<tr>
				<th>Mobile</th>
				<td>${emp.ud.mobile}</td>
			</tr>
			<tr>
				<th>Email</th>
				<td>${emp.ud.email}</td>
			</tr>
			<tr>
				<th>Password</th>
				<td>${emp.ud.password}</td>
			</tr>
			<tr>
				<th>Address</th>
				<td>${emp.ud.address}</td>
			</tr>
			<tr>
				<th>State</th>
				<td>${emp.ud.state}</td>
			</tr>
			<tr>
				<th>City</th>
				<td>${emp.ud.city}</td>
			</tr>
			<tr>
				<th>Pincode</th>
				<td>${emp.ud.pincode}</td>
			</tr>
			<tr>
				<th>Car Make</th>
				<td>${emp.vd.carMake}</td>
			</tr>
			<tr>
				<th>Car Model</th>
				<td>${emp.vd.carModel}</td>
			</tr>
			<tr>
				<th>Ex Showroom Price</th>
				<td>${emp.vd.exShowroomPrice}</td>
			</tr>
			<tr>
				<th>Type Of Employment</th>
				<td>${emp.id.typeOfEmployment}</td>
			</tr>
			<tr>
				<th>Annual Income</th>
				<td>${emp.id.annualIncome}</td>
			</tr>
			<tr>
				<th>Existing Emi</th>
				<td>${emp.id.existingEmi}</td>
			</tr>
			<tr>
				<th>LoanId</th>
				<td>${emp.lo.loanId}</td>
			</tr>
			<tr>
				<th>Loan Amount</th>
				<td>${emp.lo.loanAmount}</td>
			</tr>
			<tr>
				<th>Tenure</th>
				<td>${emp.lo.tenure}</td>
			</tr>
			<tr>
				<th>Interest Rate</th>
				<td>${emp.lo.interestRate}</td>
			</tr>
			<tr>
				<th>Status</th>
				<td>${emp.lo.status}</td>
			</tr>



		</c:forEach>

	</table>
	<br>

	<a href="../viewclient">Back</a>
</body>
</html>