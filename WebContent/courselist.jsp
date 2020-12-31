<%@page import="com.elearning.dao.CourseDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Course Info List</title>
<script type="text/javascript" src="http://localhost:8080/elearning/js/course.js"></script>
<style>
	.center {
	  margin: 15% auto;
	  width: 70%;
	  padding: 10px;
	}
	
	.addNew{
		border-radius: 0.5rem;
		margin-bottom: 1rem;
		width: 5rem;
		height: 2rem;
		background-color: #00FF00;
		border: 0px;
	}
	
	.update{
		border-radius: 0.5rem;
		width: 5rem;
		height: 2rem;
		background-color: #FFA500;
		border: 0px;
	}
	
	.delete{
		border-radius: 0.5rem;
		width: 5rem;
		height: 2rem;
		background-color: #FF0000;
		border: 0px;
	}
	
	input[type='button']:hover{
		cursor: pointer;
	}
</style>
</head>
<body>
	<div style='position:fixed;top:0%;left:0%;'>
		<%@ include file="topmenu.jsp" %>
	</div>
	
	<div class="center">
		<form method="get" name="frmCourseList">
			<div><input type="button" name="butNew" value="New" class="addNew" onclick="location.href='/elearning/courseentry.jsp'"></div>
			<%
				List<String> lsCourse = new CourseDAO().selectAllCourse();
			%>
			<table>
				<tr>
					<th>COURSE ID</th>
					<th>COURSE NAME</th>
					<th>COURSE DESCRIPTION</th>
					<th>COURSE BATH NO</th>
					<th>COURSE START DATE</th>
					<th>COURSE END DATE</th>
					<th colspan="2" style="width: 200px;">ACTIONS</th>
				</tr>
				<% for(int i=0;i<lsCourse.size();i++){ %>
				<% String rowStyle = i % 2 == 0 ? "#f2f2f2" : "#CCCCCC"; %>
				<% String strTemp = lsCourse.get(i).substring(1, lsCourse.get(i).indexOf("]")); %>
				<tr style="background-color: <%= rowStyle %>">
					<td><%= strTemp.split(",")[0].trim() %></td>
					<td><%= strTemp.split(",")[1].trim() %></td>
					<td><%= strTemp.split(",")[2].trim() %></td>
					<td><%= strTemp.split(",")[3].trim() %></td>
					<td><%= strTemp.split(",")[4].trim() %></td>
					<td><%= strTemp.split(",")[5].trim() %></td>
					<td style="width: 200px;">
						<input type="button" name="butUpdate" value="Update" class="update" onclick="location.href='/elearning/courseentry.jsp?id=<%= strTemp.split(",")[0].trim() %>&status=Update'" />
						<input type="button" name="butDelete" value="Delete" class="delete" onclick="deleteCourse('<%= strTemp.split(",")[0] %>')"/>
					</td>
				</tr>
				<% } %>
				<input type="hidden" name="hidID" value="" />
				<input type="hidden" name="hidStatus" value="" />
			</table>
		</form>
	</div>
	
	<div style='position:fixed;bottom:0%;left:0%;'>
		<%@ include file="bottommenu.jsp" %>
	</div>
</body>
</html>