<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.yash.CMA.domain.*"%>
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

<jsp:useBean id="obj" class="com.yash.CMA.domain.Contact" />
    <table width="1000spx" border="1" align="center">
    
        <jsp:include page="Header1.jsp" />
		<jsp:include page="Title.jsp" />
        <tr height="400">
            <td>
    <form  action="RegistrationController" method=post >
    <div>
        
    <table style=" border-collapse: separate;border-spacing: 0 1em;" align="center">
			 <tr>
            <td colspan="2" align="center"><h2>Update User Details</h2>
			</td>
            
        </tr>
        <tr>
            <td>Contact Name:</td>
            <td><input  type="text" name="name" value="${user.getName()}">
            	<input  type="hidden" name="contactid" value="${user.getContactid()}">
            </td>
        </tr>
        
        <tr>
            <td>Email id:</td>
            <td><input  type="text"  name="email" value="${user.getEmail()}"></td>
        </tr>
        <tr>
            <td>Phone Number</td>
            <td><input  type="text"  name="phone" value="${user.getPhone()}" ></td>
        </tr>
        
      
        <tr>
            <td></td>
            <td><input type="submit" name="updatContact" value="Update"> <input type="reset" value="reset"></td>
        </tr>
    </table>
    </div>
</form></td>
        </tr>
        <jsp:include page="Footer.jsp" />
    </table>
</body>
</html>