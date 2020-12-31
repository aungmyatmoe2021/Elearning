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
	src='http://localhost:8080/elearning/js/memberinfo.js'></script>
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
		<form method="get" name="frmMemberInfoList">
			<% List<String> lsMemberList = new MemberInfoDAO().selectAllMemberInfo(); %>
			<div>
				<input type="button" name="butNew" value="New"
					onclick="location.href='/elearning/register.jsp'" class="addNew" />
			</div>
			<table>
				<tr>
					<th>MEMBER ID</th>
					<th>FIRST NAME</th>
					<th>LAST NAME</th>
					<th>USER NAME</th>
					<th>PASSWORD</th>
					<th>DOB</th>
					<th>GENDER</th>
					<th>USER ROLE ID</th>
					<th>COURSE ID</th>
					<th colspan="2" style="width: 200px;">Actions</th>
				</tr>
				<% for(int i=0;i<lsMemberList.size();i++){ %>
				<% String rowStyle = i % 2 == 0 ? "#f2f2f2" : "#CCCCCC"; %>
				<% String strTemp = lsMemberList.get(i).substring(1,lsMemberList.get(i).indexOf("]")); %>
				<tr style="background-color: <%= rowStyle %>;height:2rem;">
					<td><%= strTemp.split(",")[0] %></td>
					<td><%= strTemp.split(",")[1] %></td>
					<td><%= strTemp.split(",")[2] %></td>
					<td><%= strTemp.split(",")[3] %></td>
					<td><%= strTemp.split(",")[4] %></td>
					<td><%= strTemp.split(",")[5] %></td>
					<td><%= strTemp.split(",")[6] %></td>
					<td><%= strTemp.split(",")[7] %></td>
					<td><%= strTemp.split(",")[8] %></td>
					<td style="width: 200px;"><input type="button"
						name="butUpdate" value="Update" class="update"
						onclick="location.href='/elearning/register.jsp?id=<%= strTemp.split(",")[0] %>&status=Update'" />
						<input type="button" name="butDelete" value="Delete"
						class="delete"
						onclick="deleteMemberInfo('<%= strTemp.split(",")[0] %>')" /></td>
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