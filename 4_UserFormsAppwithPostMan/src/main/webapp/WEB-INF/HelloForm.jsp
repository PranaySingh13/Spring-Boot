<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello Form</title>
</head>
<body>
	<h2 style="color: fuchsia; text-align: center;">Amazon</h2>
	<h3 style="color: lime; text-align: center;">Welcome</h3>
	<form method="POST" action="wish">
		<table style="margin-left: auto; margin-right: auto;">
			<tr>
				<td>UserName</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Say Hello"></td>
			</tr>
		</table>
	</form>
	<video width=100% height=100% autoplay loop muted>
		<source src="/assets/video/Amazon.mp4" type="video/mp4">
	</video>
</body>
</html>