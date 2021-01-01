<%@page import="com.elearning.dao.MemberInfoDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Member Info List</title>
<script type='text/javascript'
	src='http://localhost:8181/elearning/js/memberinfo.js'></script>
<style>
.center {
	margin: 15% auto;
	width: 70%;
	padding: 10px;
}

.addNew {
	border-radius: 0.5rem;
	margin-bottom: 1rem;
	width: 5rem;
	height: 2rem;
	background-color: #00FF00;
	border: 0px;
}

.update {
	border-radius: 0.5rem;
	width: 5rem;
	height: 2rem;
	background-color: #FFA500;
	border: 0px;
}

.delete {
	border-radius: 0.5rem;
	width: 5rem;
	height: 2rem;
	background-color: #FF0000;
	border: 0px;
}

input[type='button']:hover {
	cursor: pointer;
}
</style>
</head>
<body>
	
	<div style='position: fixed; top: 0%; left: 0%;'>
		<%@ include file="topmenu.jsp"%>
	</div>

	<div class="center">
		<input type="text" name="txtUserName" />
		<input type="text" name="txtPassword" />
		<input type="button" name="butLogin" value="LogIn" />
		<input type="button" name="butForgetPassword" value="Forget Password" />
	</div>

	<div style='position: fixed; bottom: 0%; left: 0%;'>
		<%@ include file="bottommenu.jsp"%>
	</div>
</body>
</html>