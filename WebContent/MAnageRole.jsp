<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
		<tr height="40" style="background-color: antiquewhite;">
			<td><h4>
					<a href="#" Style="padding-right: 18px; padding-left: 9px;">Home</a>|<a
						href="#" Style="padding-right: 18px; padding-left: 9px;">Contact</a>|<a
						href="#" Style="padding-right: 18px; padding-left: 9px;">About
						us</a>|<a href="#" Style="padding-right: 18px; padding-left: 9px;">Service</a>
					<h4></td>
		</tr>
		<tr height="50" style="
    font-weight: 600;
    padding-left: 10px;
">
			<td>Welcome to the My Contact Application</td>
		</tr>
		<tr height="400">
			<td><form action="UserController" method=post>


					<table width="300" align="center"
						style="border-collapse: separate; border-spacing: 0 1em;">
						<tr>
							<td colspan="2" align="Center"><h2>
									Manage Role 
									<h2></td>

						</tr>
						<tr>
							<td>Enter User ID:</td>
							<td><input type="text" placeholder="Enter Username"
								name="userid" required></td>
						</tr>
						<tr>
							<td>User Role:</td>
							<td><input type="text" placeholder="Enter Role"
								name="role" required></td>
						</tr>
						<tr>
							<td>
								<button type="submit">Login</button>
								<br>
							</td>
							<td><a href="RegisterUser.jsp">Register Yourself!!s</a></td>
						</tr>
						
						<tr>
							<td colspan="2">
								
								<p>${param.message}</p>
							</td>
							
						</tr>
					</table>


				</form></td>
		</tr>
		<tr height="40" style="background-color: #000;color: #fff;">
			<td style="
    text-align: center;
			">@CopyRight Yash Technolgies pvt. Ltd. 2019</td>
		</tr>
	</table>
</body>
</html>