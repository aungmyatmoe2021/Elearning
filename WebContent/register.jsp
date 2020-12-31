<%@page import="com.elearning.dao.CourseDAO"%>
<%@page import="com.elearning.dao.UserRoleInfoDAO"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.elearning.dao.MemberInfoDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<script type="text/javascript" src="http://localhost:8080/elearning/js/memberinfo.js"></script>
<style>
	.back{
		border-radius: 0.5rem;
		width: 10rem;
		height: 3rem;
		background-color: #C0C0C0;
		border: 0px;
		font-size: 1rem;
		font-family: 'Arial';
	}
	
	.sigin{
		border-radius: 0.5rem;
		width: 21.5rem;
		height: 3rem;
		background-color: #40E0D0;
		border: 0px;
		font-size: 1rem;
		font-family: 'Arial';
	}
	
	.memberinfoText{
		border-radius: 0.5rem !important;
		width: 20rem !important;
		height: 2.5rem !important;
		border: 2px solid #9FE2BF !important;
		margin-bottom: 0.5rem !important;
		padding-left: 1rem !important;
		font-size: 1rem !important;
		font-family: 'Arial' !important;
	}
	
	input[type='button'],input[type='submit']:hover{
		cursor: pointer;
	}
	
	select{
		border-radius: 0.5rem !important;
		width: 21.5rem !important;
		height: 2.5rem !important;
		border: 2px solid #9FE2BF !important;
		margin-bottom: 0.5rem !important;
		padding-left: 1rem !important;
		font-size: 1rem !important;
		font-family: 'Arial' !important;
		width: 15rem;
	}
	
</style>
</head>
<body>
	<div style='position:fixed;top:0%;left:0%;'>
		<%@ include file="topmenu.jsp" %>
	</div>
	
	<div style='position:fixed;top:15%;left:25%;'>
		<%
			String strID = "";
			String strStatus = "New";
			String strFirstName= "";
			String strLastName = "";
			String strUserName = "";
			String strPassword = "";
			String strDOB = "";
			String strGender = "";
			String strUserRole="";
			String strUserRoleID="";
			String strCourseID="";
			
			if(request.getParameter("id") != null)
				strID = request.getParameter("id");
			if(request.getParameter("status") != null)
				strStatus = request.getParameter("status");
			
			if(strStatus.equals("Update")){
				if(strID != null){
					List<String> record = new MemberInfoDAO().selectMemberInfoByID(strID);
					String strTemp = record.get(0).substring(1,record.get(0).indexOf("]")).trim();
					strFirstName = strTemp.split(",")[1].trim();
					strLastName = strTemp.split(",")[2].trim();
					strUserName = strTemp.split(",")[3].trim();
					strPassword = strTemp.split(",")[4].trim();
					strDOB = strTemp.split(",")[5].trim();
					strGender = strTemp.split(",")[6].trim();
					strUserRoleID = strTemp.split(",")[7].trim();
					strCourseID = strTemp.split(",")[8].trim();
				}
			}
		%>
		<form method='get' name="frmMemberInfoList">
			<div>
				<input type='text' name='txtFirstName' class="memberinfoText" placeholder='First name' value="<%= strFirstName %>" style='width: 200%;' required />
			</div>
		
			<div>
				<input type='text' name='txtLastName' class="memberinfoText" placeholder='Last name' value="<%= strLastName %>" style='width: 200%;' required />
			</div>
			
			<div>
				<input type='text' name='txtUserName' class="memberinfoText" placeholder='Email or Phone Number' value="<%= strUserName %>" style='width: 200%;' required />
			</div>

			<div>
				<input type='password' name='txtPassword' class="memberinfoText" id='txtPassword' placeholder='Password' value="<%= strPassword %>" style='width: 200%;' required />
			</div>
		
			<div>
				<input type='password' name='txtRetypePassword' class="memberinfoText" id='txtRetypePassword' placeholder='Retype Password' value="<%= strPassword %>" style='width: 200%;' required />
			</div>
		
			<div>
				<input type='date' name='txtDOB' placeholder='dd-MM-yyyy' class="memberinfoText" value="<%= strDOB %>" style='width: 200%;' required />
			</div>
		
			<% if(strGender.equals("female")){ %>
				<div>
					<select name='optGender'>
						<option value='male'>Male</option>
						<option value='female' selected="selected">Female</option>
					</select>
				</div>
			<% }else{ %>
				<div>
					<select name='optGender'>
						<option value='male' selected="selected">Male</option>
						<option value='female'>Female</option>
					</select>
				</div>
			<% } %>

			<div>
				<select name='optUserRole'>
				<% 
					List<String> lsUserRole = new UserRoleInfoDAO().selectAllUserRoleInfo(); 
					for(int i=0;i<lsUserRole.size();i++){
						String strTemp = lsUserRole.get(i).substring(1,lsUserRole.get(i).indexOf("]")).trim();
						String chkUserRoleID = strTemp.split(",")[0].equals(strUserRoleID)?"selected":"";
				%>
					<option <%= chkUserRoleID %> value="<%= strTemp.split(",")[0] %>"><%= strTemp.split(",")[1] %> | <%= strTemp.split(",")[2] %></option>
				<%
					}
				%>
				</select>
			</div>
			
			<div>
				<select name='optCourse'>
				<% 
					List<String> lsCourse = new CourseDAO().selectAllCourse(); 
					for(int i=0;i<lsCourse.size();i++){
						String strTemp = lsCourse.get(i).substring(1,lsCourse.get(i).indexOf("]")).trim();
						String chkCourseID = strTemp.split(",")[0].equals(strCourseID)?"selected":"";
				%>
					<option <%= chkCourseID %> value="<%= strTemp.split(",")[0] %>"><%= strTemp.split(",")[1] %> | <%= strTemp.split(",")[2] %></option>
				<%
					}
				%>
				</select>
			</div>

			<div>
				<input type="button" name="butSigin" value="<%= strStatus %>" onclick="checkPasswordInfo()" class="sigin"/>
			</div>
		

			<div><input type='hidden' name='hidID' value='<%= strID %>' /></div>
			<div><input type='hidden' name='hidStatus' value='<%= strStatus %>' /></div>
		
			<div style='margin-top:20px;'>
				<input type="button" name="butList" value="Back to List" class="back" onclick="location.href='/elearning/memberinfolist.jsp'"/>
			</div>
		</form>
	</div>
	<div style='position:fixed;bottom:0%;left:0%;'>
		<%@ include file="bottommenu.jsp" %>
	</div>
</body>
</html>