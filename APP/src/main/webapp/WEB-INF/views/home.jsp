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
		if(result != null) {			
			for(int i = 0; i < result.size(); i++) {
				String getLink = (String)result.get(i);
				if(getLink.indexOf("https", 0) != -1){
					out.print("<a href=\"");
					result.get(i); 
					out.print("\"</a><br>");
					out.print(result.get(i)); 
				} else {
					out.print(result.get(i)); 
				}
			}
		}
	%> 
	
</body>
</html>
