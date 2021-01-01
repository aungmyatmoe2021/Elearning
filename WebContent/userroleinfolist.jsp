<%@page import="com.elearning.dao.UserRoleInfoDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Info List</title>
<script type="text/javascript"
	src="http://localhost:8181/elearning/js/userroleinfo.js"></script>
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
	<% 
		if(session.getAttribute("USER_ROLE") !=null && session.getAttribute("USER_ROLE").equals("student")) {
			response.sendRedirect("/elearning/index.jsp");
		} 
	%>

	<div style='position: fixed; top: 0%; left: 0%;'>
		<%@ include file="topmenu.jsp"%>
	</div>

	<div class="center">
		<form method="get" name="frmUserInfoList">
			<div>
				<% if(session.getAttribute("USER_ROLE") !=null && session.getAttribute("USER_ROLE").equals("admin")) { %>
					<input type="button" name="butNew" value="New" class="addNew" onclick="location.href='/elearning/userroleinfoentry.jsp'">
				<% } %>
			</div>
			<%
				List<String> lsUserInfo = new UserRoleInfoDAO().selectAllUserRoleInfo();
			%>
			<table>
				<tr>
					<th>User Role ID</th>
					<th>User Role Name</th>
					<th>User Role Description</th>
					<% if(session.getAttribute("USER_ROLE") !=null && session.getAttribute("USER_ROLE").equals("admin")) { %>
						<th colspan="2">Actions</th>
					<% } %>
				</tr>
				<% for(int i=0;i<lsUserInfo.size();i++){ %>
				<% String rowStyle = i % 2 == 0 ? "#f2f2f2" : "#CCCCCC"; %>
				<% String strTemp = lsUserInfo.get(i).substring(1, lsUserInfo.get(i).indexOf("]")); %>
				<tr style="background-color: <%= rowStyle %>">
					<td><%= strTemp.split(",")[0].trim() %></td>
					<td><%= strTemp.split(",")[1].trim() %></td>
					<td><%= strTemp.split(",")[2].trim() %></td>
					<% if(session.getAttribute("USER_ROLE") !=null && session.getAttribute("USER_ROLE").equals("admin")) { %>
						<td>
							<input type="button" name="butUpdate" value="Update" class="update" onclick="location.href='/elearning/userroleinfoentry.jsp?id=<%= strTemp.split(",")[0].trim() %>&status=Update'" />
							<input type="button" name="butDelete" value="Delete" class="delete" onclick="deleteUserRoleInfo('<%= strTemp.split(",")[0] %>')" />
						</td>
					<% } %>
				</tr>
				<% } %>
				<input type="hidden" name="hidID" value="" />
				<input type="hidden" name="hidStatus" value="" />
			</table>
		</form>
	</div>

	<div style='position: fixed; bottom: 0%; left: 0%;'>
		<%@ include file="bottommenu.jsp"%>
	</div>
</body>
</html>