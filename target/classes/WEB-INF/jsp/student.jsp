<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Management</title>
</head>
<body>
<h1>Students Data</h1>
<form:form action="student.do" method="POST" commandName="student">
	<table>
		<tr>
			<td>Student ID</td>
			<td><form:input path="studentId" /></td>
		</tr>
		<tr>
			<td>First name</td>
			<td><form:input path="studentName" /></td>
		</tr>
		<tr>
			<td>Last name</td>
			<td><form:input path="studentSurname" /></td>
		</tr>
		<tr>
			<td>Address</td>
			<td><form:input path="studentAddress" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<form:input type="submit" name="action" value="Add" path=""/>
				<form:input type="submit" name="action" value="Edit" path=""/>
				<form:input type="submit" name="action" value="Delete" path=""/>
				<form:input type="submit" name="action" value="Search" path=""/>
			</td>
		</tr>
	</table>
</form:form>
<br>
<table border="1">
	<th>ID</th>
	<th>First name</th>
	<th>Last name</th>
	<th>Year level</th>
	<c:forEach items="${studentList}" var="student">
		<tr>
			<td>${student.studentId}</td>
			<td>${student.studentName}</td>
			<td>${student.studentSurname}</td>
			<td>${student.studentAddress}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>