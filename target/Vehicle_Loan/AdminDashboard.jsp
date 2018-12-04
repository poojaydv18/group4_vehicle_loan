
<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
if(session!=null)
{
	if(session.getAttribute("isAdminLoggedIn")==null)
	{
		out.println(session.getAttribute("isAdminLoggedIn"));
		response.sendRedirect("index.jsp");
	}
}
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

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
			<a class="navbar-brand" href="#">Admin</a>
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
				data-toggle="dropdown" href="adminlogout"> <i
					class="fa fa-user fa-fw"></i> Logout </b>
			</a></li>
		</ul>
		<!-- /.navbar-top-links -->

		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">

					<li><a href="#" class="active"><i
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
					<h1 class="page-header">Dashboard</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>

		</div>


		<!-- /#wrapper -->
</body>
</html>
