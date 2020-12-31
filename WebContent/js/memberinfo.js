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
	if(frmMemberInfoList.txtPassword.value !== frmMemberInfoList.txtRetypePassword.value){
		window.alert("Password doesn't the same.")
	}else{
		frmMemberInfoList.method='get';
		frmMemberInfoList.action='/elearning/memberinfo';
		frmMemberInfoList.submit();
	}
}