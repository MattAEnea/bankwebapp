<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="link.html"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h1>
		Welcome
		<%=request.getParameter("User")%>.
	</h1>
	<p><%=request.getParameter("msg")%>?
	</p>
</body>
</html>
