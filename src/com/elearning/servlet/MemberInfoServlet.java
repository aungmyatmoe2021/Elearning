package com.elearning.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elearning.dao.MemberInfoDAO;

/**
 * Servlet implementation class MemberInfoServlet
 */
@WebServlet("/memberinfo")
public class MemberInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("[MemberInfoServlet]doPost is starting here");
		doProcess(request, response);
		System.out.println("[MemberInfoServlet]doPost is ending here");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[MemberInfoServlet]doPost is starting here");
		doProcess(request, response);
		System.out.println("[MemberInfoServlet]doPost is ending here");
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[MemberInfoServlet]doProcess is starting here");
		String hidID="";
		String hidStatus="";
		String strFirstName = "";
		String strLastName = "";
		String strUserName = "";
		String strPassword = "";
		String strRetypePassword = "";
		String strDOB = "";
		String strGender = "";
		String strUserRoleID = "";
		String strCourseID = "";
		String strMessage = "";
		
		if(request.getParameter("txtFirstName")!=null)
			strFirstName = request.getParameter("txtFirstName").trim();
		if(request.getParameter("txtLastName")!=null)
			strLastName = request.getParameter("txtLastName").trim();
		if(request.getParameter("txtUserName")!=null)
			strUserName = request.getParameter("txtUserName").trim();
		if(request.getParameter("txtPassword")!=null)
			strPassword = request.getParameter("txtPassword").trim();
		if(request.getParameter("txtRetypePassword")!=null)
			strRetypePassword = request.getParameter("txtRetypePassword").trim();
		if(request.getParameter("txtDOB")!=null)
			strDOB = request.getParameter("txtDOB").trim();
		if(request.getParameter("optGender")!=null)
			strGender = request.getParameter("optGender").trim();
		if(request.getParameter("optGender")!=null)
			strGender = request.getParameter("optGender").trim();
		if(request.getParameter("optGender")!=null)
			strGender = request.getParameter("optGender").trim();
		if(request.getParameter("optUserRole")!=null)
			strUserRoleID = request.getParameter("optUserRole").trim();
		if(request.getParameter("optCourse")!=null)
			strCourseID = request.getParameter("optCourse").trim();
		if(request.getParameter("hidID")!=null)
			hidID = request.getParameter("hidID").trim();
		if(request.getParameter("hidStatus")!=null)
			hidStatus = request.getParameter("hidStatus").trim();
		
		
		if(hidStatus.equals("Update")) {
			if(request.getParameter("hidID")!=null) {
				strMessage = new MemberInfoDAO().updateMemberInfo(hidID, strFirstName, strLastName, strPassword, strDOB, strGender, strUserRoleID, strCourseID);
			}
		}else if(hidStatus.equals("New")){
			System.out.println(strUserRoleID+"~~"+strCourseID);
			strMessage = new MemberInfoDAO().insertMemberInfo(strFirstName, strLastName, strUserName, strPassword, strDOB, strGender, strUserRoleID, strCourseID);
		}else if(hidStatus.equals("Delete")) {
			strMessage = new MemberInfoDAO().deleteMemberInfo(hidID);
		}
		
		if(strMessage.equals("success"))
			response.sendRedirect("/elearning/memberinfolist.jsp");
		else
			response.sendRedirect("/elearning/register.jsp");
		
		System.out.println("[MemberInfoServlet]doProcess is ending here");
	}
}
