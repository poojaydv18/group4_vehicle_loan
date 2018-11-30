<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html> 
<head>
<style>

</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script href="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script language="JavaScript" type="text/javascript" 
			src="local.js" ></script>
<script language="JavaScript" type="text/javascript" 
			src="car.js"></script>

 <link rel="stylesheet" href="eligibility.css">


</head>
<body background="images/bg1.png">
<form method="post" action="Confirmation.jsp">

  <div class="container">

<h4> Vehicle Details:</h4>


<label for="Car Make"><b><i class="fa fa-car" aria-hidden="true"></i> Car Make</b></label>
    <div class='resp_code frms'>
      
       
      <div id="selection">
        <select id="listBox" onchange='selct_car(this.value)'></select>
</div>
<label for="Car Model"><b><i class="fa fa-car " aria-hidden="true"></i> Car Model</b></label>
<div class='resp_code frms'>
	
        <select id='secondlist'></select>
      </div>
      <div id="dumdiv" align="center" style=" font-size: 10px;color: #dadada;">
        <a id="dum" style="padding-right:0px; text-decoration:none;color: green;text-align:center;" href="http://www.hscripts.com"></a>
      </div>
    </div>

 
 
<label><i class="fa fa-university" aria-hidden="true"></i> Ex-Showroom Price:</label>
    <input type="number" pattern="[1-9]{4-9}" id="exshowroomprice"  name="Ex-Showroom Price" placeholder="Enter Value" title="enter number format" required><br><br>

<label><i class="fa fa-university" aria-hidden="true"></i> On Road Price</label>
    <input type="number" pattern="[1-9]{4-9}" id="onroadprice" name="On Road Price" placeholder="Enter Value" title="enter number format" required><br>
   <hr>


<h4> Applicant Details:</h4>

<label><i class="fa fa-user" aria-hidden="true"></i> Name:</label>
   <input type="text" id="user" name="user" placeholder="Enter Full Name" required><br><br>

    

<label><i class="fa fa-calendar" aria-hidden="true"></i> Age</label>
    <input type="number" id="age" name="age" placeholder="Enter your age" min="21" max="65" required><br><br>

<label><i class="fa fa-venus-mars" aria-hidden="true"></i> Gender:</label><br>
<div class='resp_code frms'>

   <!--  <select required id="gender">
        <option>select category</option>
    <option value="Male">Male</option>
	<option value="Female">Female</option>
<option value="others">Others</option>
 </select> -->
 <input type="radio" name="gender" value="male" checked> Male<br>
  <input type="radio" name="gender" value="female"> Female<br>
  <input type="radio" name="gender" value="other"> Other  
</div>
<br><br>
<label><i class="fa fa-user-plus" aria-hidden="true"></i> Type Of Employment:</label>
<div class='resp_code frms'>
    <select required id="employmenttype">
    <option>select </option>
    <option value="Salaried">Salaried</option>
    <option value="Self-Employed">Self-Employed</option>
    </select>
</div>
<br><br>
<label><i class="fa fa-inr fa-fw" aria-hidden="true"></i> Yearly Salary:</label>
    <input type="number" pattern="[1-9]{4-9}" title="enter number format" id="yearlysalary" name="Yearly Salary" placeholder="Enter Yearly Salary" required><br><br>


<label><i class="fa fa-user" aria-hidden="true"></i> Existing EMI</label></br>
    <input type="number" pattern="[1-9]{4-9}" title="enter number format"  id="existingemi" name="Existing EMI" placeholder="Existing EMI" ><br><br>
<hr>
<h4>Contact Details</h4>
<label><i class="fa fa-phone" aria-hidden="true"></i> Mobile No:</label>
    <input type="number" pattern="[6-9]{1}[0-9]{9}" title="Please enter a valid mobile number"maxlength="10" id="mobile" name="Mobile No:" placeholder="Enter Mobile No:" required><br><br>

<label><i class="fa fa-envelope" aria-hidden="true"></i> Email ID</label>
    <input type="text" id="email" name="" placeholder="Enter Email ID" pattern="[a-zA-Z]{1}[a-zA-Z0-9._%+-]+@[a-z.-]+\.[a-z]{2,3}$" required><br>
<hr>
<!-- <h4>Identify Yourself</h4>
 -->
 <div>
<input type=submit class="save" value="Submit">
<!-- <button id="myBtn" class="row" >Check Eligibility</button>
 -->    </div>
</form>




</body>
</html>