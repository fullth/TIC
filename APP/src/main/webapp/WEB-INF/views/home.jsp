<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<form action="/getNews">
		<input type="text" name="topic"> <input type="submit"
			value="submit">
	</form>
	<% 	
		List<Object> result = (List) request.getAttribute("result");
		for(int i = 0; i < result.size(); i++) {
			%> 
			<a href="
			<% out.println(result.get(i)); %>
			"><% out.print(result.get(i)); %></a><br>
		<% } %>
	
</body>
</html>
