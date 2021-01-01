/**
 * 
 */

function deleteMemberInfo(id){
	if(window.confirm('Are you sure delete this record?')){
		frmMemberInfoList.hidID.value = id;
		frmMemberInfoList.hidStatus.value = 'Delete';
		
		frmMemberInfoList.method='get';
		frmMemberInfoList.action='/elearning/memberinfo';
		frmMemberInfoList.submit();
	}
}

function checkPasswordInfo(){
	if(frmMemberInfoList.txtFirstName.value === ""){
		document.getElementById('lblFirstName').innerHTML = '*First Name shouldn\'t be blank*';
		return;
	}else if(frmMemberInfoList.txtFirstName.value !== ""){
		document.getElementById('lblFirstName').innerHTML = '';
	}
	
	if(frmMemberInfoList.txtLastName.value === ""){
		document.getElementById('lblLastName').innerHTML = '*Last Name shouldn\'t be blank*';
		return;
	}else if(frmMemberInfoList.txtLastName.value !== ""){
		document.getElementById('lblLastName').innerHTML = '';
	}
	
	if(frmMemberInfoList.txtUserName.value === ""){
		document.getElementById('lblUserName').innerHTML = '*User Name shouldn\'t be blank*';
		return;
	}else if(frmMemberInfoList.txtUserName.value !== ""){
		document.getElementById('lblUserName').innerHTML = '';
	}
	
	if(frmMemberInfoList.txtPassword.value === ""){
		document.getElementById('lblPassword').innerHTML = '*Password shouldn\'t be blank*';
		return;
	}else if(frmMemberInfoList.txtPassword.value !== ""){
		document.getElementById('lblPassword').innerHTML = '';
	}
	
	if(frmMemberInfoList.txtRetypePassword.value === ""){
		document.getElementById('lblRetypePassword').innerHTML = '*ReType Password shouldn\'t be blank*';
		return;
	}else if(frmMemberInfoList.txtRetypePassword.value !== ""){
		document.getElementById('lblRetypePassword').innerHTML = '';
	}
	
	if(frmMemberInfoList.txtDOB.value === ""){
		document.getElementById('lblDOB').innerHTML = '*Date Of Birth shouldn\'t be blank*';
		return;
	}else if(frmMemberInfoList.txtDOB.value !== ""){
		document.getElementById('lblDOB').innerHTML = '';
	}
	
	if(frmMemberInfoList.optGender.value === "selectedGender"){
		document.getElementById('lblGender').innerHTML = '*Gender shouldn\'t be blank*';
		return;
	}else if(frmMemberInfoList.optGender.value !== ""){
		document.getElementById('lblGender').innerHTML = '';
	}
	
	if(frmMemberInfoList.optUserRole.value === "selectedUserRole"){
		document.getElementById('lblUserRole').innerHTML = '*User Role shouldn\'t be blank*';
		return;
	}else if(frmMemberInfoList.optUserRole.value !== ""){
		document.getElementById('lblUserRole').innerHTML = '';
	}
	
	if(frmMemberInfoList.optCourse.value === "selectedCourse"){
		document.getElementById('lblCourse').innerHTML = '*Course shouldn\'t be blank*';
		return;
	}else if(frmMemberInfoList.optCourse.value !== ""){
		document.getElementById('lblCourse').innerHTML = '';
	}
	
	if(frmMemberInfoList.txtPassword.value !== frmMemberInfoList.txtRetypePassword.value){
		window.alert("Password doesn't the same.");
		return;
	}else{
		frmMemberInfoList.method='get';
		frmMemberInfoList.action='/elearning/memberinfo';
		frmMemberInfoList.submit();
	}
}