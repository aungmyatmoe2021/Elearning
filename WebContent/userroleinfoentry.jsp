<%@page import="com.elearning.dao.UserRoleInfoDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New User Info</title>
<script type='text/javascript'
	src='http://localhost:8080/elearning/js/userinfo.js'></script>
<style>
.back {
	border-radius: 0.5rem;
	width: 10rem;
	height: 3rem;
	background-color: #C0C0C0;
	border: 0px;
	font-size: 1rem;
	font-family: 'Arial';
}

.sigin {
	border-radius: 0.5rem;
	width: 25rem;
	height: 3rem;
	background-color: #40E0D0;
	border: 0px;
	font-size: 1rem;
	font-family: 'Arial';
}

label {
	margin-bottom: 0.5rem;
	font-size: 1rem;
	font-family: 'Arial';
}

.userInfoText {
	border-radius: 0.5rem !important;
	width: 24rem !important;
	height: 2.5rem !important;
	border: 2px solid #9FE2BF !important;
	margin-bottom: 0.5rem !important;
	padding-left: 1rem !important;
	font-size: 1rem !important;
	font-family: 'Arial' !important;
}

input[type='submit'], input[type='button'], input[type='reset']:hover {
	cursor: pointer;
}

select {
	width: 15rem;
}
</style>
</head>
<body>
	<div style='position: fixed; top: 0%; left: 0%;'>
		<%@ include file="topmenu.jsp"%>
	</div>

	<% 
		String strUserRoleID = ""; 
		String strStatus = "New";
		String strUserRoleName = "";
		String strUserRoleDesp = "";
		if(request.getParameter("status") != null){
			strStatus = request.getParameter("status").trim();
		}
		
		if(strStatus.equals("Update")){
			if(request.getParameter("id") != null){
				strUserRoleID = request.getParameter("id").trim();
				List<String> record = new UserRoleInfoDAO().selectUserRoleInfoByID(strUserRoleID);
				strUserRoleName = record.get(0).substring(1,record.get(0).indexOf("]")).split(",")[1].trim();
				strUserRoleDesp = record.get(0).substring(1,record.get(0).indexOf("]")).split(",")[2].trim();
			}
		}
	%>

	<div style='position: fixed; top: 25%; left: 25%;'>
		<form method='get' name="frmUserInfo" action="/elearning/userroleinfo">

			<div style='width: 100%; margin-bottom: 5px;'>
				<input type='text' name='txtUserRoleName'
					placeholder="User Role Name" class="userInfoText"
					id='txtUserRoleName' value='<%= strUserRoleName%>' required />
			</div>

			<div style='width: 100%; margin-bottom: 5px;'>
				<input type='text' name='txtUserRoleDesp'
					placeholder="User Role Description" class="userInfoText"
					id='txtUserRoleDesp' value='<%= strUserRoleDesp%>' required />
			</div>

			<div style='width: 100%; margin-bottom: 5px;'>
				<input type='submit' Value='<%= strStatus %>' class="sigin">
			</div>

			<div style='width: 100%; margin-bottom: 5px;'>
				<input type='reset' Value='Cancel' class="sigin">
			</div>

			<div>
				<input type='hidden' name='hidID' value='<%= strUserRoleID %>' />
			</div>
			<div>
				<input type='hidden' name='hidStatus' value='<%= strStatus %>' />
			</div>

			<div style='margin-top: 20px;'>
				<input type="button" name="butList" value="Back to List"
					class="back"
					onclick="location.href='/elearning/userroleinfolist.jsp'" />
			</div>

		</form>
	</div>

	<div style='position: fixed; bottom: 0%; left: 0%;'>
		<%@ include file="bottommenu.jsp"%>
	</div>
</body>
</html>