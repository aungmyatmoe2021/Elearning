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