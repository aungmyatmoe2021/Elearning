<%@page import="com.elearning.dao.CourseDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Info Entry</title>
<script type='text/javascript'
	src='http://localhost:8181/elearning/js/course.js'></script>
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
	width: 21.5rem;
	height: 3rem;
	background-color: #40E0D0;
	border: 0px;
	font-size: 1rem;
	font-family: 'Arial';
}

.courseText {
	border-radius: 0.5rem !important;
	width: 20rem !important;
	height: 2.5rem !important;
	border: 2px solid #9FE2BF !important;
	margin-bottom: 0.5rem !important;
	padding-left: 1rem !important;
	font-size: 1rem !important;
	font-family: 'Arial' !important;
}

input[type='button'], input[type='submit']:hover {
	cursor: pointer;
}

select {
	border-radius: 0.5rem !important;
	width: 20rem !important;
	height: 2.5rem !important;
	border: 2px solid #9FE2BF !important;
	margin-bottom: 0.5rem !important;
	padding-left: 1rem !important;
	font-size: 1rem !important;
	font-family: 'Arial' !important;
}

.errorMessage{
	color:red;
}
</style>
</head>
<body>
	<% 
		if(session.getAttribute("USER_ROLE") !=null) {
			if (session.getAttribute("USER_ROLE").equals("student") || session.getAttribute("USER_ROLE").equals("manager") || session.getAttribute("USER_ROLE").equals("staff") || session.getAttribute("USER_ROLE").equals("teacher")){
				response.sendRedirect("/elearning/index.jsp");	
			}
		} 
	%>

	<div style='position: fixed; top: 0%; left: 0%;'>
		<%@ include file="topmenu.jsp"%>
	</div>

	<% 
		String strCourseID = ""; 
		String strStatus = "New";
		String strCourseName = "";
		String strCourseDesp = "";
		String strCourseBathNo = "";
		String strCourseStartDate = "";
		String strCourseEndDate = "";
		if(request.getParameter("status") != null){
			strStatus = request.getParameter("status").trim();
		}
		
		if(strStatus.equals("Update")){
			if(request.getParameter("id") != null){
				strCourseID = request.getParameter("id").trim();
				List<String> record = new CourseDAO().selectCourseByID(strCourseID);
				strCourseName = record.get(0).substring(1,record.get(0).indexOf("]")).split(",")[1].trim();
				strCourseDesp = record.get(0).substring(1,record.get(0).indexOf("]")).split(",")[2].trim();
				strCourseBathNo = record.get(0).substring(1,record.get(0).indexOf("]")).split(",")[3].trim();
				strCourseStartDate = record.get(0).substring(1,record.get(0).indexOf("]")).split(",")[4].trim();
				strCourseEndDate = record.get(0).substring(1,record.get(0).indexOf("]")).split(",")[5].trim();
			}
		}
	%>

	<div style='position: fixed; top: 25%; left: 25%;'>
		<form method='get' name="frmCourse" >
			<div>
				<input type='text' name='txtCourseName' class="courseText"
					placeholder='Course name' value="<%= strCourseName %>"
					style='width: 200%;' required />
				<label id="lblCourseName" class="errorMessage"></label>
			</div>

			<div>
				<input type='text' name='txtCourseDesp' class="courseText"
					placeholder='Course Description' value="<%= strCourseDesp %>"
					style='width: 200%;' required />
				<label id="lblCourseDesp" class="errorMessage"></label>
			</div>

			<div>
				<input type='text' name='txtCourseBathNo' class="courseText"
					placeholder='Course Bath No' value="<%= strCourseBathNo %>"
					style='width: 200%;' required />
				<label id="lblCourseBathNo" class="errorMessage"></label>
			</div>

			<div>
				<input type='date' name='txtCourseStartDate' class="courseText"
					placeholder='dd-MM-yyyy' value="<%= strCourseStartDate %>"
					style='width: 200%;' required />
				<label id="lblCourseStartDate" class="errorMessage"></label>
			</div>

			<div>
				<input type='date' name='txtCourseEndDate' class="courseText"
					placeholder='dd-MM-yyyy' value="<%= strCourseEndDate %>"
					style='width: 200%;' required />
				<label id="lblCourseEndDate" class="errorMessage"></label>
			</div>

			<div style='width: 100%; margin-bottom: 5px;'>
				<input type='button' Value='<%= strStatus %>' class="sigin" onclick="checkValidation()" />
			</div>

			<div style='width: 100%; margin-bottom: 5px;'>
				<input type='reset' Value='Cancel' class="sigin">
			</div>

			<div>
				<input type='hidden' name='hidID' value='<%= strCourseID %>' />
			</div>
			<div>
				<input type='hidden' name='hidStatus' value='<%= strStatus %>' />
			</div>

			<div style='margin-top: 20px;'>
				<input type="button" name="butList" value="Back to List"
					class="back" onclick="location.href='/elearning/courselist.jsp'" />
			</div>

		</form>
	</div>

	<div style='position: fixed; bottom: 0%; left: 0%;'>
		<%@ include file="bottommenu.jsp"%>
	</div>
</body>
</html>