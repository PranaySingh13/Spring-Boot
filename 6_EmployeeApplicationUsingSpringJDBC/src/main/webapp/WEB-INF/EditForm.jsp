<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GK Software Solutions</title>
</head>
<body>
<jsp:include page="/WEB-INF/home.jsp"/>
<br><br><br><br><br>
<form method="post" action="update">
	<table style="margin-left: auto;margin-right: auto;background-color: yellow;">
		<tr>
			<td style="font-weight: bolder;">Employee Id: </td>
			<td>${emp.empId}</td>
		</tr>
		<tr>
			<td style="font-weight: bolder;">Employee Name: </td>
			<td><input type="text" name="ename" value="${emp.empName}"></td>
		</tr>
		<tr>
			<td style="font-weight: bolder;">Employee Address: </td>
			<td><input type="text" name="eaddr" value="${emp.empAddress}"></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Update"></td>
		</tr>
	</table>
	<input type="hidden" name="eid" value="${emp.empId}">
</form>
</body>
</html>