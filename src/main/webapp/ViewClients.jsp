<%-- <%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
if(session!=null)
{
	if(session.getAttribute("isAdminLoggedIn")==null)
	{
		out.println(session.getAttribute("isAdminLoggedIn"));
		response.sendRedirect("Index.jsp");
	}
}
%> --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ page errorPage="ErrorPage.jsp" %>  

<!DOCTYPE html >
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<title>Admin Dashboard</title>

<!-- Bootstrap Core CSS -->
<link href="admincss/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="admincss/metisMenu.min.css" rel="stylesheet">

<!-- Timeline CSS -->
<link href="admincss/timeline.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="admincss/startmin.css" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="admincss/morris.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="admincss/font-awesome.min.css" rel="stylesheet"
	type="text/css">

</head>
<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="navbar-header">
			<a class="navbar-brand" href="AdminDashboard.jsp">Admin</a>
		</div>

		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>

		<ul class="nav navbar-nav navbar-left navbar-top-links">
			<li><a href="Index.jsp"><i class="fa fa-home fa-fw"></i>
					Website</a></li>
		</ul>

		<ul class="nav navbar-right navbar-top-links">


			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="Index.jsp"> <i
					class="fa fa-user fa-fw"></i> Logout </b>
			</a></li>
		</ul>
		<!-- /.navbar-top-links -->

		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">

					<li><a href="AdminDashboard.jsp" class="active"><i
							class="fa fa-dashboard fa-fw"></i> Dashboard</a></li>
					<li><a href="#"><i class="fa fa-bar-chart-o fa-fw"></i>
							Clients</a> <!-- /.nav-second-level --></li>
					<li><a href="viewclient""><i class="fa fa-table fa-fw"></i>
							Application</a></li>
					<li><a href="#"><i class="fa fa-edit fa-fw"></i> Rejected
							List</a></li>


				</ul>

				</li>
				</ul>
			</div>
		</div>
		</nav>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">

					<h1>Application List</h1>
					<table border="2" width="70%" cellpadding="2">
						<tr>
							<th>Loan Id</th>
							<th>User Id</th>
							<th>Loan Amount</th>
							<th>Tenure</th>
							<th>Interest Rate</th>
							<th>Status</th>
							<th>Photo</th>
							<th>Aadhar Card</th>
							<th>Pan Card</th>
							<th>Pay Slip</th>
							<th>View Application</th>
							<th>Approve</th>
							<th>Reject</th>
						</tr>
						<c:forEach var="vc" items="${list}">
							<tr>
								<td>${vc.loanId}</td>
								<td>${vc.userId}</td>
								<td>${vc.loanAmount}</td>
								<td>${vc.tenure}</td>
								<td>${vc.interestRate}</td>
								<td>${vc.status}</td>
								<td><a href="dispfile/${vc.userId}/${1}">Photo</a></td>
								<td><a href="dispfile/${vc.userId}/${2}">Aadhar Card</a></td>
								<td><a href="dispfile/${vc.userId}/${3}">Pan Card</a></td>
								<td><a href="dispfile/${vc.userId}/${4}">Pay Slip</a></td>
								<td><a href="editclient/${vc.userId}">View</a></td>
								<td><a href="clientapprove/${vc.userId}/${vc.loanAmount}">Approve</a></td>
								<td><a href="clientreject/${vc.userId}">Reject</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<!-- /.col-lg-12 -->
			</div>

		</div>
<script>
    $(document).ready(function () {

       
    });
</script>

		<!-- /#wrapper -->
</body>
</html>
