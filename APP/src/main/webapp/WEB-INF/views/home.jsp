<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<form action="/app/getNews">
		<input type="text" name="topic">
		<input type="submit" value="submit">
	</form>
	${result}
</body>
</html>
