<!-- <html>
<body>

<ul>
	<li><a href="http://localhost:8081/SpringMVC/users/page">Click here to enter into the Page </a></li>
</ul>
</body>
</html> -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<h3 align="center">${headerMessage}</h3>
<table align="center">
            <tr>
                <td><a href="/SpringMVC/users/login">Login</a>
                </td>
                <td><a href="/SpringMVC/users/page">Register</a>
                </td>
            </tr>
        </table>
</body>
</html>
