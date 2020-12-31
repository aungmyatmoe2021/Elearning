package com.elearning.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elearning.dao.UserRoleInfoDAO;

/**
 * Servlet implementation class UserRoleInfoServlet
 */
@WebServlet("/userroleinfo")
public class UserRoleInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRoleInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("[UserRoleInfoServlet] doGet is starting here.");
		doProcess(request, response);
		System.out.println("[UserRoleInfoServlet] doGet is ending here.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("[UserRoleInfoServlet] doPost is starting here.");
		doProcess(request, response);
		System.out.println("[UserRoleInfoServlet] doPost is ending here.");
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[UserRoleInfoServlet] doProcess is starting here.");
		String strUserRoleName = "";
		String strUserRoleDesp = "";
		String strHidID = "";
		String strHidStatus = "";
		String strMessage="";
		
		
		if(request.getParameter("txtUserRoleName") != null) 
			strUserRoleName = request.getParameter("txtUserRoleName").trim();
		
		if(request.getParameter("txtUserRoleDesp") != null)
			strUserRoleDesp = request.getParameter("txtUserRoleDesp").trim();
		
		if(request.getParameter("hidID")!= null)
			strHidID = request.getParameter("hidID").trim();
		
		if(request.getParameter("hidStatus")!= null)
			strHidStatus = request.getParameter("hidStatus").trim();
		
		if(strHidStatus.equals("New")) 
			strMessage = new UserRoleInfoDAO().insertUserRoleInfo(strUserRoleName, strUserRoleDesp);
		
		if(strHidStatus.equals("Update")) 
			strMessage = new UserRoleInfoDAO().updateUserInfo(strHidID, strUserRoleName, strUserRoleDesp);
		
		if(strHidStatus.equals("Delete")) 
			strMessage = new UserRoleInfoDAO().deleteUserInfo(strHidID);
		
		if (strMessage.equals("success"))
			response.sendRedirect("/elearning/userroleinfolist.jsp");
		else
			response.sendRedirect("/elearning/userroleinfoentry.jsp");
		
		System.out.println("[UserRoleInfoServlet] doProcess is ending here.");
	}
}
