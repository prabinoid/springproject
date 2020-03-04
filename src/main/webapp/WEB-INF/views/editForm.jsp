<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spring"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <%@ include file="header.jsp" %>

	<h1>Employee Form</h1>
	<hr>

	<spring:form action="${pageContext.request.contextPath}/update" method="post" modelAttribute="emodel">

		<table>
			<tr>
				<td>FirstName</td>
				<td><spring:input path="fname" required="true"  /></td>
			</tr>

			<tr>
				<td>LastName</td>
				<td><spring:input path="lname" /></td>
			</tr>

			<tr>
				<td>Gender</td>
				<td>
				   <spring:radiobutton path="gender" value="male"/> Male
				   <spring:radiobutton path="gender" value="female"/>Female
				</td>
			</tr>
			<tr>
				<td>DOB</td>
				<td><spring:input path="dob" type="date" required="true" /></td>
			</tr>

			<tr>
				<td>JoinDate</td>
				<td><spring:input path="joinDate" type="date"  required="true" /></td>
			</tr>

			<tr>
				<td>Company</td>
				<td><spring:input path="company" /></td>
			</tr>

			<tr>
				<td>Post</td>
				<td><spring:input path="post" /></td>
			</tr>

			<tr>
				<td>Phone</td>
				<td><spring:input path="phone" /></td>
			</tr>

			<tr>
				<td>Email</td>
				<td><spring:input path="email" /></td>
			</tr>

			<tr>
				<td>Salary</td>
				<td><spring:input path="salary" required="true"  /></td>
			</tr>

			<tr>
				<td>Country</td>
				<td><spring:input path="address.country" /></td>
			</tr>

			<tr>
				<td>City</td>
				<td><spring:input path="address.city" /></td>
			</tr>

			<tr>
				<td>State</td>
				<td>
				    <spring:select path="address.state">
				      <spring:option value="">---select---</spring:option>
				      <spring:option value="1">state-1</spring:option>
				      <spring:option value="2">state-2</spring:option>
				      <spring:option value="3">state-3</spring:option>
				      <spring:option value="4">state-4</spring:option>
				      <spring:option value="5">state-5</spring:option>
				      <spring:option value="6">state-6</spring:option>
				      <spring:option value="7">state-7</spring:option>
				    </spring:select>
				
				</td>
			</tr>

			<tr>
				<td>Zip</td>
				<td><spring:input path="address.zip" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Update"></td>
			</tr>

		</table>
		
		<spring:hidden path="id"/>
		<spring:hidden path="address.id"/>

	</spring:form>



</body>
</html>