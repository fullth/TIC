<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Welcome to fullth web</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="../resources/css/main.css" />
</head>
<body class="is-preload">
	<!-- Wrapper -->
	<div id="wrapper">
		<!-- Main -->
		<div id="main">
			<div class="inner">
				<!-- Header -->
				<header id="header">
					<h1 class="main">JOIN</h1>
				</header>
				<div class="main">
					<br>
					<form action="/join" method="post" name="joinForm">					
						<br>	
						<label>ID<input type="text" name="USER_ID" ></label>
						<label>Name<input type="text" name="USER_NAME" ></label>
						<label>Email<input type="text" name="USER_EMAIL" ></label>
						<label>Password<input type="password" name="USER_PW"></label>
						<label>Password Check<input type="password" name="USER_PWC" ></label>
						<input type="submit" name="join" value="join">
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- Scripts -->
	<script src="../resources/js/account.js"></script>
	<script src="../resources/js/jquery.min.js"></script>
	<script src="../resources/js/browser.min.js"></script>
	<script src="../resources/js/breakpoints.min.js"></script>
	<script src="../resources/js/util.js"></script>
	<script src="../resources/js/main.js"></script>
</body>
</html>