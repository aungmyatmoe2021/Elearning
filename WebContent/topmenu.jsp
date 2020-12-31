<style>
/* Add a black background color to the top navigation */
.topnav {
	background-color: rgba(51,51,51, 1.5);
	overflow: hidden;
	width: 100vw;
}

/* Style the links inside the navigation bar */
.topnav a {
	float: left;
	color: #f2f2f2;
	text-align: center;
	padding: 15px 10px;
	text-decoration: none;
	font-size: 17px;
}

/* Change the color of links on hover */
.topnav a:hover {
	background-color: #ddd;
	color: black;
}

/* Add a color to the active/current link */
.topnav a.active {
	background-color: #4CAF50;
	color: white;
}
</style>

<%
	String strDefault="",strMember="",strUserInfo="",strCourseInfo="",strAbout="",strContact="";
	if(request.getRequestURL().toString().indexOf("default") > 0)
		strDefault="active";
	if(request.getRequestURL().toString().indexOf("memberinfo") > 0 || request.getRequestURL().toString().indexOf("register") > 0)
		strMember="active";
	if(request.getRequestURL().toString().indexOf("userroleinfo") > 0 )
		strUserInfo="active";
	if(request.getRequestURL().toString().indexOf("course") > 0 )
		strCourseInfo="active";
	if(request.getRequestURL().toString().indexOf("aboutus") > 0 )
		strAbout="active";
	if(request.getRequestURL().toString().indexOf("contactus") > 0 )
		strContact="active";
%>

<div class="topnav">
	<% System.out.println(request.getRequestURL().toString()); %>
	<a class="<%= strDefault %>"
		href="http://localhost:8181/elearning/default.jsp">HOME</a> <a
		class="<%= strMember %>"
		href="http://localhost:8181/elearning/memberinfolist.jsp">MEMBER
		LIST</a> <a class="<%= strUserInfo %>"
		href="http://localhost:8181/elearning/userroleinfolist.jsp">USER
		INFO LIST</a> <a class="<%= strCourseInfo %>"
		href="http://localhost:8181/elearning/courselist.jsp">COURSE INFO
		LIST</a> <a class="<%= strAbout %>"
		href="http://localhost:8181/elearning/aboutus.jsp">ABOUT US</a> <a
		class="<%= strContact %>"
		href="http://localhost:8181/elearning/contactus.jsp">CONTACT US</a>
	<%@ include file="login.jsp"%>
</div>