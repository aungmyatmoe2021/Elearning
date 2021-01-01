/**
 * 
 */

function deleteUserRoleInfo(id){
	if(window.confirm("Are you sure delete this record?")){
		frmUserInfoList.hidID.value = id;
		frmUserInfoList.hidStatus.value= 'Delete';
		
		frmUserInfoList.method="get";
		frmUserInfoList.action = "/elearning/userroleinfo";
		frmUserInfoList.submit();
	}
}

function checkValidation(){
	if(frmUserInfo.txtUserRoleName.value === ""){
		document.getElementById('lblUserRoleName').innerHTML = '*User Role Name shouldn\'t be blank*';
		return;
	}else if(frmUserInfo.txtUserRoleName.value !== ""){
		document.getElementById('lblUserRoleName').innerHTML = '';
	}
	
	if(frmUserInfo.txtUserRoleDesp.value === ""){
		document.getElementById('lblUserRoleDesp').innerHTML = '*User Role Description shouldn\'t be blank*';
		return;
	}else if(frmUserInfo.txtUserRoleDesp.value !== ""){
		document.getElementById('lblUserRoleDesp').innerHTML = '';
	}
	
	if(frmUserInfo.txtUserRoleName.value !== "" && frmUserInfo.txtUserRoleDesp.value !== ""){
		frmUserInfo.method='get';
		frmUserInfo.action='/elearning/userroleinfo';
		frmUserInfo.submit();
	}
}