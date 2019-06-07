<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.yash.CMA.domain.*"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
   <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Document</title>
</head>
<body>
<Form action="ContactController" method="post">


	<jsp:useBean id="obj" class="com.yash.CMA.controller.ContactController" />
	<table width="1000spx" border="1" align="center">
		<jsp:include page="Header1.jsp" />
		<jsp:include page="Title.jsp" />
		
		<tr height="400">
			<td style="padding-bottom: 300px">
				<div>
			
					<input type="submit"  name="deleteMultipleContact" value="DeleteMultiple">
				 <input type="text" name="searchuserid"> <input type="submit"
						name="searchContact"  value="SearchContact"><input type="submit"  name="AddCustomer" value="AddCustomer">
				</div>
				<div style="padding-top: 20px">
					<table>
						<tr>
							<th style="padding-right: 80px;" align="left">Select</th>
							<th style="padding-right: 80px;" align="left">CustomerID</th>
							<th style="padding-right: 80px;" align="left">Name</th>
							<th style="padding-right: 80px;" align="left">Email</th>
							<th style="padding-right: 80px;" align="left">Phone</th>
							<th style="padding-right: 80px;" align="left">Delete</th>
							<th style="padding-right: 80px;" align="left">Edit</th>

						</tr>
						<c:forEach items="${userList}" var="user">
							<tr>
								<td><input type="checkbox" name="delete" value="${user.getContactid()}" ></td>
								<td ><c:out value="${user.getContactid()}"/></td>
								<td><c:out value="${user.getName()}" /></td>
								<td><c:out value="${user.getEmail()}" /></td>
								<td><c:out value="${user.getPhone()}" /></td>
								<td>
								<input type="hidden" name="deleteContactid" value="${user.getContactid()}">
								<input type="submit" name="DeleteContact" value="Delete"></td>
								<td>
								<input type="hidden" name="EditContactId" value="${user.getContactid()}">
								<input type="submit" name="EditContact" value="Edit">
								</td>
								
								
							</tr>
						</c:forEach>
					</table>

				</div>
			</td>
		</tr>
			<jsp:include page="Footer.jsp" />
	</table>
	</Form>
</body>
</html>