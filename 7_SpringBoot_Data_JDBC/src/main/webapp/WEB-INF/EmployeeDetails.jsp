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
<table style="margin-left: auto;margin-right: auto;background-color: yellow;">
	<tr>
		<td style="font-weight: bolder;">Student Id: </td>
		<td style="font-style: italic;">${emp.empId}</td>
	</tr>
	<tr>
		<td style="font-weight: bolder;">Student Name: </td>
		<td style="font-style: italic;">${emp.empName}</td>
	</tr>
	<tr>
		<td style="font-weight: bolder;">Student Address: </td>
		<td style="font-style: italic;">${emp.empAddress}</td>
	</tr>
</table>
</body>
</html>