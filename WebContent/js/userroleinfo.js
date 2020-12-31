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