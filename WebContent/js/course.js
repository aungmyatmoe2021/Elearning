/**
 * 
 */
function deleteCourse(id){
	if(window.confirm("Are you sure delete this record?")){
		frmCourseList.hidID.value=id;
		frmCourseList.hidStatus.value='Delete';
		
		frmCourseList.method='get';
		frmCourseList.action='/elearning/course';
		frmCourseList.submit();
	}
}

function checkValidation(){
	if(frmCourse.txtCourseName.value === ""){
		document.getElementById('lblCourseName').innerHTML = '*Course Name shouldn\'t be blank*';
		return;
	}else if(frmCourse.txtCourseName.value !== ""){
		document.getElementById('lblCourseName').innerHTML = '';
	}
	
	if(frmCourse.txtCourseDesp.value === ""){
		document.getElementById('lblCourseDesp').innerHTML = '*Course Description shouldn\'t be blank*';
		return;
	}else if(frmCourse.txtCourseDesp.value !== ""){
		document.getElementById('lblCourseDesp').innerHTML = '';
	}
	
	if(frmCourse.txtCourseBathNo.value === ""){
		document.getElementById('lblCourseBathNo').innerHTML = '*Course Bath No shouldn\'t be blank*';
		return;
	}else if(frmCourse.txtCourseBathNo.value !== ""){
		document.getElementById('lblCourseBathNo').innerHTML = '';
	}
	
	if(frmCourse.txtCourseStartDate.value === ""){
		document.getElementById('lblCourseStartDate').innerHTML = '*Course Start Date shouldn\'t be blank*';
		return;
	}else if(frmCourse.txtCourseStartDate.value !== ""){
		document.getElementById('lblCourseStartDate').innerHTML = '';
	}
	
	if(frmCourse.txtCourseEndDate.value === ""){
		document.getElementById('lblCourseEndDate').innerHTML = '*Course End Date shouldn\'t be blank*';
		return;
	}else if(frmCourse.txtCourseEndDate.value !== ""){
		document.getElementById('lblCourseEndDate').innerHTML = '';
	}
	
	if(frmCourse.txtCourseName.value !== "" && frmCourse.txtCourseDesp.value !== "" && frmCourse.txtCourseBathNo.value !== "" && frmCourse.txtCourseStartDate.value !== "" && frmCourse.txtCourseEndDate.value !== ""){
		frmCourse.method='get';
		frmCourse.action='/elearning/course';
		frmCourse.submit();
	}
}