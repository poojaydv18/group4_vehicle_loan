<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>EMI Calculator</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">
<style>
input:invalid {
	color: red;
}

#emicalc {
	display: none;
}

.button {
	background-color: BLACK;
	border: none;
	color: white;
	padding: 5px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 15px;
	margin: 4px 2px;
	cursor: pointer;
}

.button4 {
	border-radius: 12px;
}

body, html {
	height: 100%;
	margin: auto;
	/* The image used */
	background-image: url("images/bg1.png");
	/* Full height */
	height: 100%;
	/* Center and scale the image nicely */
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}

form {
	border: 3px solid #f1f1f1;
	width: 30%;
	height: 450px;
	margin: auto;
	padding: 80px;
	color: white;
	background-color: #1C3653;
}

.table {
	border-collapse: collapse;
	width: 100%;
	margin: 10px 10px;
}

th, td {
	text-align: left;
	padding: 8px;
}

button {
	background-color: black;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

input[type=text], input[type=number] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

.container {
	padding: 16px;
}
</style>
<script type="text/javascript">
        function emi()
        {
                var principal = document.formval.principal_amt.value; // pick principal value from from..
                var rate_interest = document.formval.rate.value;
				var roi = (rate_interest)/(100*12);
                var tenure = document.formval.tenure.value; // pick tenure value from from..
                var tenureinmonths = tenure * 12;
                var compoundinterest = (principal * roi * Math.pow((1+roi),tenureinmonths))/(Math.pow((1+roi),tenureinmonths)-1); 
                var emi = Math.ceil(compoundinterest * 100) / 100; //
    			if(principal>=0 && roi>=0 && tenure>=0){
                document.formval.fieldemi.value = emi.toFixed(2);     // to assign value in emi as fixed upto two decimal..
    			}
    			else
    				document.write("Invalid inputs");
        } 
        </script>
</head>
<body>

	<br>
	<form name="formval">
		<table cellpadding=3>

			<center>
				<a href="Index.jsp"> <i class="fa fa-home fa-fw fa-4x"
					aria-hidden="true" style="color: BLACK"></i></a>
			</center>

			<h2>
				<b><u><CENTER>EMI CALCULATOR</CENTER></u></b>
			</h2>

			<tr>
				<td>Loan Amount :</td>
				<td><input name="principal_amt" type="number" min="1"
					max="100000000" oninput="validity.valid||(value='');"
					pattern="[1-9]{4-9}"></td>
			</tr>
			<tr>
				<td>Tenure(in years) :</td>
				<td><input name="tenure" type="number" min="1" max="100000000"
					oninput="validity.valid||(value='');" pattern="[1-9]{4-9}"></td>
			</tr>
			<tr>
				<td>Rate of interest :</td>
				<td><input name="rate" type="text" min="1" max="100000000"
					oninput="validity.valid||(value='');"
					pattern="[0-9]+(\.[0-9]{0,2})?%?"></td>
			</tr>
			<br>
			<br>

			<tr>
				<td>EMI :</td>
				<td><input name="fieldemi" type="text" id="emicalc" readonly></td>
			</tr>
			<tr>

			</tr>
		</table>
		<input type="button" class="button button4" name="calculate"
			value="Calculate" onclick="emi(); myFunction();">
	</form>

	<script>
function myFunction() {
    var x = document.getElementById("emicalc");
        x.style.display = "block";
}
</script>
</body>
</html>