<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file = "/static/link.html"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Created</title>
</head>
<body>
	<h1>
		Account
		<%=request.getParameter("User")%>
		created.
	</h1>
	<p><%=request.getParameter("msg")%>?
	</p>
</body>
</html>
