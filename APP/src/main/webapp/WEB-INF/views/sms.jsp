<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Test send SMS</title>
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
					<h1 class="main">SEND SMS</h1>
				</header>
				
				<div class="main">
					<br>
					<form action="/sendSms">		
						<br>
						<label>
							TO <input type="text" name="to">
						</label>
						<label>
							FROM <input type="text" name="from">
						</label>
						<label>
							TEXT <input type="text" name="text">
						</label>
						<input type="submit" name="Send" value="submit">
					</form>
				</div>

			</div>
		</div>
	</div>

	<!-- Scripts -->
	<script src="../resources/js/jquery.min.js"></script>
	<script src="../resources/js/browser.min.js"></script>
	<script src="../resources/js/breakpoints.min.js"></script>
	<script src="../resources/js/util.js"></script>
	<script src="../resources/js/main.js"></script>

</body>
</html>