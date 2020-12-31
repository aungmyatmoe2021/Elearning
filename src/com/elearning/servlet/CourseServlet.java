package com.elearning.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elearning.dao.CourseDAO;
import com.elearning.dao.MemberInfoDAO;

/**
 * Servlet implementation class CourseServlet
 */
@WebServlet("/course")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("[Course Servlet]doGet is starting here.");
		doProcess(request, response);
		System.out.println("[Course Servlet]doGet is ending here.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("[Course Servlet]doPost is starting here.");
		doProcess(request, response);
		System.out.println("[Course Servlet]doPost is ending here.");
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[Course Servlet]doProcess is starting here.");
		
		String hidID="";
		String hidStatus="";
		String strCourseName = "";
		String strCourseDesp = "";
		String strCourseBathNo = "";
		String strCourseStartDate = "";
		String strCourseEndDate = "";
		String strMessage = "";
		
		if(request.getParameter("txtCourseName")!=null)
			strCourseName = request.getParameter("txtCourseName").trim();
		if(request.getParameter("txtCourseDesp")!=null)
			strCourseDesp = request.getParameter("txtCourseDesp").trim();
		if(request.getParameter("txtCourseBathNo")!=null)
			strCourseBathNo = request.getParameter("txtCourseBathNo").trim();
		if(request.getParameter("txtCourseStartDate")!=null)
			strCourseStartDate = request.getParameter("txtCourseStartDate").trim();
		if(request.getParameter("txtCourseEndDate")!=null)
			strCourseEndDate = request.getParameter("txtCourseEndDate").trim();
		if(request.getParameter("hidID")!=null)
			hidID = request.getParameter("hidID").trim();
		if(request.getParameter("hidStatus")!=null)
			hidStatus = request.getParameter("hidStatus").trim();
		
		if(hidStatus.equals("Update")) {
			if(request.getParameter("hidID")!=null) {
				strMessage = new CourseDAO().updateCourse(hidID, strCourseName, strCourseDesp, strCourseBathNo, strCourseStartDate, strCourseEndDate);
			}
		}else if(hidStatus.equals("New")){
			strMessage = new CourseDAO().insertCourse(strCourseName, strCourseDesp, strCourseBathNo, strCourseStartDate, strCourseEndDate);
		}else if(hidStatus.equals("Delete")) {
			strMessage = new CourseDAO().deleteCourse(hidID);
		}
		
		if(strMessage.equals("success"))
			response.sendRedirect("/elearning/courselist.jsp");
		else
			response.sendRedirect("/elearning/courseentry.jsp");
		
		System.out.println("[Course Servlet]doProcess is ending here.");
	}

}
