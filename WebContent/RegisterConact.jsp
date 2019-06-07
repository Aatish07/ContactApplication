<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <table width="1000spx" border="1" align="center">
    <tr height="40">
            <td><h4><a href="#">Home</a>|<a href="#">Contact</a>|<a href="#">About us</a>|<a href="#">Service</a><h4s></td>
        </tr>
        <tr height="50">
            <td>Welcome to the My Contact Application</td>
        </tr>
        <tr height="400">
            <td>
    <form  action="RegistrationController" method=post >
    <div>
        
    <table style=" border-collapse: separate;border-spacing: 0 1em;" align="center">
			 <tr>
            <td colspan="2" align="center"><h2>User Registration</h2>
			</td>
            
        </tr>
          <tr>
            <td>Contact Id:</td>
            <td><input  type="text" name="contactid" required></td>
        </tr>
        <tr>
            <td>User Name:</td>
            <td><input  type="text" name="name" required></td>
        </tr>
        
        <tr>
            <td>Email id:</td>
            <td><input  type="email"  name="email" required></td>
        </tr>
        <tr>
            <td>Phone Number</td>
            <td><input  type="text"  name="phone" required></td>
        </tr>
      
        <tr>
            <td></td>
            <td><input type="submit" name="saveContact" value="Save"> <input type="reset" value="reset"></td>
        </tr>
    </table>
    </div>
</form></td>
        </tr>
        <tr height="40">
            <td>@CopyRight Yash Technolgies pvt. Ltd. 2019</td>
        </tr>
    </table>
</body>
</html>