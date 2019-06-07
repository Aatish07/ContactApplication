<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ page import="javax.swing.*"%>
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
		<jsp:include page="Header.jsp" />
		<jsp:include page="Title.jsp" />
		
		
		<tr height="400">
			<td><form action="UserController" method=post>

	<%String msg=(String)request.getAttribute("Messageid");
	if(msg!=null){
		JOptionPane.showMessageDialog(null, msg, "Warning", JOptionPane.PLAIN_MESSAGE);
		
	} %>

					<table width="300" align="center"
						style="border-collapse: separate; border-spacing: 0 1em;">
						<tr>
							<td colspan="2" align="Center"><h2>
									Login
									<h2></td>

						</tr>
						<tr>
							<td>User Name:</td>
							<td><input type="text" placeholder="Enter Username"
								name="name" required></td>
						</tr>
						<tr>
							<td>Password:</td>
							<td><input type="password" placeholder="Enter Password"
								name="password" required><br></td>
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
								
								
							</td>		<td></td>
							
						</tr>
					</table>


				</form></td>
		</tr>
			<jsp:include page="Footer.jsp" />
	</table>
</body>
</html>