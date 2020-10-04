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
<form action="delete" method="post">
	<table style="margin-left: auto;margin-right: auto;background-color: yellow;">
		<tr>
			<td style="font-weight: bolder;">Employee Id: </td>
			<td><input type="text" name="eid"></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Delete"></td>
		</tr>
	</table>
</form>
</body>
</html>