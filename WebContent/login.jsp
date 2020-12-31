<style>
.frmDesign {
	float: right;
	color: #f2f2f2;
	text-align: center;
	padding: 15px 16px;
	text-decoration: none;
	font-size: 17px;
}

.welcomDesign {
	float: right;
	color: #f2f2f2;
	margin-top: -5px;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

input[type='text'], input[type='password'] {
	border-radius: 0.5rem;
	width: 10rem;
	height: 1.5rem;
	border: 2px solid #9FE2BF;
	margin-bottom: -10rem;
	padding-left: 0.5rem;
	font-size: 1rem;
	font-family: 'Arial';
}

.buttonStyle {
	border-radius: 0.5rem;
	width: 5rem;
	height: 1.5rem;
	background-color: #CCCCCC;
	border: 0px;
	font-size: 1rem;
	font-family: 'Arial';
}

.buttonStyle:hover {
	cursor: pointer;
}
</style>

<% if (session.getAttribute("USER_NAME") != null) { %>
<div class="welcomDesign">
	Welcome
	<%= session.getAttribute("USER_NAME").toString().trim() %>
	<input type="submit" name="butLogout" value="Log Out"
		class="buttonStyle" onclick="location.href='/elearning/logout'" />
</div>
<% }else{ %>
<form name="frmLogIn" method="post" action="/elearning/login">
	<div class="frmDesign">
		<input type="text" name="txtUserName" required /> <input
			type="password" name="txtPassword" required /> <input type="submit"
			name="butLogin" value="Log In" class="buttonStyle" /> <input
			type="reset" name="butReset" value="Cancel" class="buttonStyle" />
	</div>
</form>
<% } %>