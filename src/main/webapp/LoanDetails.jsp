<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="js/back.js"></script>

<style>
input:invalid {
	color: red;
}

body {
	font-family: Arial, Helvetica, sans-serif;
	background-color: teal;
}

form {
	width: 50%;
	margin: auto;
}

* {
	box-sizing: border-box;
}

/* Add padding to containers */
.container {
	padding: 16px;
	background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password], input[type=number] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus, input[type=number]:focus
	{
	background-color: #ddd;
	outline: none;
}

input[type=submit] {
	width: 100%;
	background-color: black;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

/* Overwrite default styles of hr */
hr {
	border: 1px solid #f1f1f1;
	margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
	background-color: #4CAF50;
	color: white;
	padding: 16px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}

.registerbtn:hover {
	opacity: 1;
}

/* Add a blue text color to links */
a {
	color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
	background-color: #f1f1f1;
	text-align: center;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
// Check if the localStorage object exists
if(localStorage){

$( window ).load(function() {
    
  document.getElementById("loanamount").value =sessionStorage.getItem("store_eligibleloan");

  document.getElementById("tenure").value =sessionStorage.getItem("store_loantenure");

  document.getElementById("interestrate").value =sessionStorage.getItem("store_interestrate");
 

});
  
} else{
    alert("Sorry, your browser do not support local storage.");
}
</script>
</head>
<body>

	<form action="saveLoan" method="POST">
		<div class="container">
			<div class="container">
				<div class="signup-content">

					<div class="signup-form">
						<!--   <form class="register-form" id="register-form" method="POST" > -->
						<div style="background-color: black; color: white; padding: 20px;">
							<h2>Loan Details</h2>
						</div>
						<br>
						<div class="form-group">
							<label for="loan amount">Loan Amount :</label> <input type="text"
								id="loanamount" name="loanAmount" required readonly />
						</div>

						<div class="form-group">
							<label for="Tenure">Tenure( in months) :</label> <input
								type="number" id="tenure" name="tenure" min="" max="84" required />
						</div>
						<div class="form-group">
							<label for="Interest Rate">Interest Rate :</label> <input
								type="text" id="interestrate" name="interestRate" value="9.25"  required readonly />
						</div>
						<hr noshade>
						<div class="form-group">

							<input type="hidden" id="status" name="status" value="PENDING"
								required />
						</div>

						<div class="form-submit">
							<input type=submit class="save" value="Submit">

						</div>




						<!--   </form> -->
					</div>
				</div>
			</div>

		</div>

	</form>

</body>
</html>
